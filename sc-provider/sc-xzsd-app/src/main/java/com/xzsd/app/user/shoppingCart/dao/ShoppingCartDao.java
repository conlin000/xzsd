package com.xzsd.app.user.shoppingCart.dao;

import com.xzsd.app.user.shoppingCart.entity.ShoppingCartInfo;
import com.xzsd.app.user.shoppingCart.entity.ShoppingCartListVO;
import com.xzsd.app.user.shoppingCart.entity.ShoppingCartSumPriceVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingCartDao {

    /**
     * 购物车新增
     * @description 购物车新增
     * @function addShoppingCart
     * @param shoppingCartInfo (goodsCode, goodsCount)
     * @type&return int
     * @author Conlin
     * @date
     */
    int addShoppingCart(ShoppingCartInfo shoppingCartInfo);


    /**
     * 购物车删除
     * @description 购物车删除
     * @function removeShoppingCart
     * @param shoppingCartIdList
     * @type&return int
     * @author Conlin
     * @date
     */
    int removeShoppingCart(@Param("shoppingCartIdList") List<String> shoppingCartIdList);


    /**
     * 修改商品数量
     * @description 修改商品数量
     * @function updateGoodsCount
     * @param shoppingCartId, goodsCount
     * @type&return int
     * @author Conlin
     * @date
     */
    int updateGoodsCount(@Param("shoppingCartId") String shoppingCartId, @Param("goodsCount") String goodsCount);


    /**
     * 合计购物车价格查询
     * @description 被选中的购物车查询，计算被选中的购物车数量和总价格
     * @function checkShoppingCart
     * @param shoppingCartId, userCode
     * @type&return int
     * @author Conlin
     * @date
     */
    List<ShoppingCartSumPriceVO> checkShoppingCart(@Param("shoppingCartId") List<String> shoppingCartId, @Param("userId") String userId);



    /**
     * 购物车（列表）查询
     * @description 购物车（列表）查询，分页查询
     * @function shoppingCartWithList
     * @param shoppingCartListVO (pageNum, pageSize)
     * @type&return int
     * @author Conlin
     * @date
     */
    List<ShoppingCartInfo> shoppingCartWithList(ShoppingCartListVO shoppingCartListVO);

}
