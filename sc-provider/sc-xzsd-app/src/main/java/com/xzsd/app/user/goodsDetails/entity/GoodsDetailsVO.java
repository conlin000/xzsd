package com.xzsd.app.user.goodsDetails.entity;


/***
 * app-用户端：商品信息查询VO实体类
 */
public class GoodsDetailsVO {

    // 商品名字
    private String goodsName;

    // 商品预览图
    private String goodsImages;

    // 书本介绍
    private String booksIntroduction;

    // 售价
    private float sellingPrice;

    // 商品评分（0-2差评， 3-4中评， 5好评）
    private float goodsScore;

    // 到达地
    private String storeName;


    /**
     * setter & getter
     */
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getGoodsImages() {
        return goodsImages;
    }

    public void setGoodsImages(String goodsImages) {
        this.goodsImages = goodsImages;
    }

    public String getBooksIntroduction() {
        return booksIntroduction;
    }

    public void setBooksIntroduction(String booksIntroduction) {
        this.booksIntroduction = booksIntroduction;
    }

    public float getGoodsScore() {
        return goodsScore;
    }

    public void setGoodsScore(float goodsScore) {
        this.goodsScore = goodsScore;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }
}
