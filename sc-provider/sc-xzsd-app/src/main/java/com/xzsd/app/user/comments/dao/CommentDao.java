package com.xzsd.app.user.comments.dao;
import com.xzsd.app.user.comments.entity.AppOrderCommentVO;
import com.xzsd.app.user.comments.entity.CommentWithListVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentDao {


    /**
     * 商品评论（列表）查询
     * @description 商品评论（列表）查询,分页查询
     * @function commentsWithList
     * @param commentWithListVO
     * @type&return List<CommentWithListVO>
     * @author Conlin
     * @date
     */
    List<CommentWithListVO> commentsWithList(CommentWithListVO commentWithListVO);



    /**
     * app用户端订单评论
     * @description app用户端订单评论
     * @function orderComment
     * @param
     * @type&return int
     * @author Conlin
     * @date
     */
    int orderComment(AppOrderCommentVO orderCommentVO);


    /**
     * app用户端订单评论 ==> 统计商品的评分+修改订单状态
     * @description app用户端订单评论 ==> 统计商品的评分+修改订单状态
     * @function updateGoodsSocreAndOrderState
     * @param
     * @type&return int
     * @author Conlin
     * @date
     */
    int updateGoodsSocreAndOrderState(String orderCode);
}
