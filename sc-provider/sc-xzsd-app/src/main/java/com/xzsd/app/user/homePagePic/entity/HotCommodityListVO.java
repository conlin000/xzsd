package com.xzsd.app.user.homePagePic.entity;

/**
 * app-用户端：首页热门商品列表查询
 */
public class HotCommodityListVO {


    // 热门商品id
    private String hotCommodityID;

    // 热门位排序号：0-无排序
    private String hotSortNo;

    // 商品编号
    private String goodsCode;

    // 商品名称
    private String goodsName;

    // 售价
    private float sellingPrice;

    // 商品图片路径
    private String imagePath;

    // 版本号
    private int version;


    /**
     * setter & getter
     */

    public String getHotCommodityID() {
        return hotCommodityID;
    }

    public void setHotCommodityID(String hotCommodityID) {
        this.hotCommodityID = hotCommodityID;
    }

    public String getHotSortNo() {
        return hotSortNo;
    }

    public void setHotSortNo(String hotSortNo) {
        this.hotSortNo = hotSortNo;
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

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }
}
