package com.xzsd.app.user.homePagePic.entity;


/**
 * app-用户端：图片（列表）查询VO实体类
 */
public class ImagesWithListVO {

    // 图片编码
    private String imageCode;

    // 图片排序号
    private int sortNo;

    // 图片路径
    private String imagePath;

    // 商品编号
    private String goodsCode;


    /**
     * setter & getter
     */

    public int getSortNo() {
        return sortNo;
    }

    public void setSortNo(int sortNo) {
        this.sortNo = sortNo;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }
}
