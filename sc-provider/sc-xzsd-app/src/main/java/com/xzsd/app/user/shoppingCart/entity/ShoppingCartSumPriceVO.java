package com.xzsd.app.user.shoppingCart.entity;

/**
 * app-用户端：购物车合计总价VO实体类
 */
public class ShoppingCartSumPriceVO {

    // 购物车id
    private String shoppingCartId;

    // 用户编号
    private String userCode;

    // 总价
    private float totalPrice;

    // 选中的购物车数量
    private int shoppingCartCount;


    /**
     * getter & setter
     */
    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getShoppingCartCount() {
        return shoppingCartCount;
    }

    public void setShoppingCartCount(int shoppingCartCount) {
        this.shoppingCartCount = shoppingCartCount;
    }

}
