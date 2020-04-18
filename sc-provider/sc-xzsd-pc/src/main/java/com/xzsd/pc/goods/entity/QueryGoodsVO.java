package com.xzsd.pc.goods.entity;


import java.util.Date;

/***
 * pc-商品信息查询VO实体类
 */
public class QueryGoodsVO {

    // 商品编码
    private String goodsCode;

    // 商品名字
    private String goodsName;

    // isbn书号
    private String isbnNum;

    // 一级分类编码
    private String firClassCode;

    // 一级分类名称
    private String firClassName;

    // 二级分类编码
    private String secClassCode;

    // 二级分类名称
    private String secClassName;

    // 出版社
    private String press;

    // 作者
    private String author;

    // 库存
    private int stock;

    // 售价
    private float sellingPrice;

    // 定价
    private float costPrice;

    // 商品预览图
    private String goodsImages;

    // 销售量
    private int sales;

    // 商品评分： 0~2差评  3~4中评  5好评
    private float goodsScore;

    // 商品状态：0-在售  1-已下架  2-未发布
    private Integer goodsState;

    // 上架时间
    private Date onSellingTime;

    // 浏览量
    private int views;

    // 版本号
    private int version;


    /**
     * setter & getter
     */
    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getIsbnNum() {
        return isbnNum;
    }

    public void setIsbnNum(String isbnNum) {
        this.isbnNum = isbnNum;
    }

    public String getFirClassCode() {
        return firClassCode;
    }

    public void setFirClassCode(String firClassCode) {
        this.firClassCode = firClassCode;
    }

    public String getFirClassName() {
        return firClassName;
    }

    public void setFirClassName(String firClassName) {
        this.firClassName = firClassName;
    }

    public String getSecClassCode() {
        return secClassCode;
    }

    public void setSecClassCode(String secClassCode) {
        this.secClassCode = secClassCode;
    }

    public String getSecClassName() {
        return secClassName;
    }

    public void setSecClassName(String secClassName) {
        this.secClassName = secClassName;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public String getGoodsImages() {
        return goodsImages;
    }

    public void setGoodsImages(String goodsImages) {
        this.goodsImages = goodsImages;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public float getGoodsScore() {
        return goodsScore;
    }

    public void setGoodsScore(float goodsScore) {
        this.goodsScore = goodsScore;
    }

    public Integer getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Integer goodsState) {
        this.goodsState = goodsState;
    }

    public Date getOnSellingTime() {
        return onSellingTime;
    }

    public void setOnSellingTime(Date onSellingTime) {
        this.onSellingTime = onSellingTime;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
}
