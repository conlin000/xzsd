package com.xzsd.app.user.goodsDetails.dao;

import com.xzsd.app.user.goodsDetails.entity.GoodsDetailsVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GoodsDetailsDao {


    /**
     * APP商品详情查询（点击跳转）
     * @description APP商品详情查询（点击跳转）
     * @function GoodsDetailsDao
     * @param goodsCode
     * @type&return GoodsDetailsVO
     * @author Conlin
     * @date
     */
    List<GoodsDetailsVO> goodsDetails(String goodsCode);


    /**
     * 查询到达地
     * @description 通过邀请码查询到达地
     * @function findStore
     * @param userCode
     * @type&return String
     * @author Conlin
     * @date
     */
    String findStore(String userCode);


    /**
     * 更新浏览量
     * @description 更新浏览量
     * @function updateViews
     * @param goodsCode
     * @type&return int
     * @author Conlin
     * @date
     */
    int updateViews(String goodsCode);


    /**
     * “购物车”查询（点击跳转）
     * @description “购物车”查询（点击跳转）
     * @function shoppingCartList
     * @param userCode
     * @type&return String
     * @author Conlin
     * @date
     */

}
