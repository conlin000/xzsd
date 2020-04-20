package com.xzsd.app.user.comments.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.JsonUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.user.comments.dao.CommentDao;
import com.xzsd.app.user.comments.entity.AppOrderCommentVO;
import com.xzsd.app.user.comments.entity.CommentWithListVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentService {


    @Resource
    private CommentDao commentDao;


    /**
     * app-商品评论（列表）查询
     * @description 商品评论（列表）查询,分页查询
     * @function commentsWithList
     * @param commentWithListVO (goodsCode)
     * @type&return List<CommentWithListVO>
     * @author Conlin
     * @date
     */
    public AppResponse commentsWithList(CommentWithListVO commentWithListVO){
        // 商品评论（列表）查询
        List<CommentWithListVO> commentListVOWithList = commentDao.commentsWithList(commentWithListVO);
        return AppResponse.success("查询成功", commentListVOWithList);
    }



    /**
     * app用户端订单评论
     * @description app用户端订单评论
     * @function orderComment
     * @param commentJson
     * @type&return int
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse orderComment(String commentJson){
        // 将Json转换成对象
        AppOrderCommentVO orderCommentVO = JsonUtils.fromJson(commentJson, AppOrderCommentVO.class);
        // 获取当前用户，并配置创建者和评论人
        orderCommentVO.setCreator(SecurityUtils.getCurrentUserId());
        orderCommentVO.setUserCode(SecurityUtils.getCurrentUserId());
        orderCommentVO.setUseName(SecurityUtils.getCurrentUserUsername());
        // 循环次数是订单评价的条数
        for (int i = 0; i < orderCommentVO.getCommentInfoVOList().size(); i++) {
            // 生成评论编码，并配置
            orderCommentVO.getCommentInfoVOList().get(i).setCommentCode(StringUtil.getCommonCode(3));
            // 若没有填写分数，默认好评
            if (orderCommentVO.getCommentInfoVOList().get(i).getGoodsCode() == null){
                orderCommentVO.getCommentInfoVOList().get(i).setScore(5);
            }
        }
        // 提交评论
        int flag = commentDao.orderComment(orderCommentVO);
        if (flag == 0){
            return AppResponse.bizError("评论失败");
        }
        // 统计商品的评分+修改订单状态
        flag = commentDao.updateGoodsSocreAndOrderState(orderCommentVO.getOrderCode());
        return AppResponse.success("成功");
    }
}
