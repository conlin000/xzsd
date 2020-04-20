package com.xzsd.app.user.catalogue.entity;

/**
 * app-用户端：商品分类查询VO实体类
 */
public class ViewCommodityVO {

    // 商品编号
    private String goodsCode;

    // 商品名称
    private String goodsName;

    // 售价
    private float sellingPrice;

    // 商品图片路径
    private String imagePath;



    /**
     * setter & getter
     */

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

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
