package com.xzsd.pc.order.entity;

import java.util.List;

/***
 * pc-订单详情查询VO
 */
public class QueryOrderVO {

    // 用户编号
    private String userCode;

    // 订单编号
    private String orderCode;

    // 购物车id串
    private String shoppingCartIdList;

    // 商品编号
    private String goodsCode;

    // 版本号
    private int version;

    // 购物车id（通过购物车id查询商品的信息）
    private List<ShoppingCartListVO> shoppingCart;




    /**
     * setter & getter
     */
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<ShoppingCartListVO> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(List<ShoppingCartListVO> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public String getShoppingCartIdList() {
        return shoppingCartIdList;
    }

    public void setShoppingCartIdList(String shoppingCartIdList) {
        this.shoppingCartIdList = shoppingCartIdList;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
}
