package com.xzsd.app.storeOwner.order.entity;

/**
 * App订单（列表）和详情查询的子实体类：购物车VO实体类
 */
public class ShoppingCartListVO {

    // 购物车id
    private String shoppingCartId;

    // 商品编号
    private String goodsCode;

    // 商品名称
    private String goodsName;

    // 商品图片路径
    private String imagePath;

    // 商品介绍(通过商品编号查的)(非数据库字段)
    private String bookIntroduction;

    // 售价
    private float sellingPrice;

    // 商品数量
    private int goodsCount;



    /**
     * getter & setter
     */
    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public String getBookIntroduction() {
        return bookIntroduction;
    }

    public void setBookIntroduction(String bookIntroduction) {
        this.bookIntroduction = bookIntroduction;
    }
}
