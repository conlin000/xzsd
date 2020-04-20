package com.xzsd.app.user.goodsDetails.service;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.user.goodsDetails.dao.GoodsDetailsDao;
import com.xzsd.app.user.goodsDetails.entity.GoodsDetailsVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class GoodsDetailsService {


    @Resource
    private GoodsDetailsDao goodsDetailsDao;


    /**
     * APP商品详情查询（点击跳转）
     * @description APP商品详情查询（点击跳转）
     * @function GoodsDetailsDao
     * @param goodsCode
     * @type&return GoodsDetailsVO
     * @author Conlin
     * @date
     */
    public AppResponse goodsDetails(String goodsCode){
        // APP商品详情查询
        List<GoodsDetailsVO> goodsDetailsVO = goodsDetailsDao.goodsDetails(goodsCode);
        // 获取当前用户编号
        String userCode = SecurityUtils.getCurrentUserId();
        // "到达地查询",并配置
        goodsDetailsVO.get(0).setStoreName(goodsDetailsDao.findStore(userCode));
        // 更新浏览量
        goodsDetailsDao.updateViews(goodsCode);
        return AppResponse.success("查询成功", goodsDetailsVO);
    }




}
