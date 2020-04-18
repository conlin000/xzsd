package com.xzsd.pc.goods.entity;

import java.util.Date;

/**
 * pc-商品（列表）查询VO实体类
 */
public class GoodsWithListVO {

    // 商品编码
    private String goodsCode;

    // 商品名字
    private String goodsName;

    // 定价
    private float costPrice;

    // 售价
    private float sellingPrice;

    // 销售量
    private int sales;

    // 一级分类名称
    private String firClassName;

    // 二级分类名称
    private String secClassName;

    // 广告词
    private String advertisement;

    // 书本介绍
    private String booksIntroduction;

    // 商品状态：0-在售  1-已下架  2-未发布
    private Integer goodsState;

    // 上架时间
    private String onSellingTime;

    // 浏览量
    private Integer views;

    // 库存
    private Integer stock;

    // 出版社
    private String press;

    // 作者
    private String author;

    // isbn书号
    private String isbnNum;

    // 创建时间
    private Date createTime;

    // 版本号
    private int version;

    // 当前页码
    private int pageNum;

    // 一页的数据条数
    private int pageSize;


    /**
     * setter & getter
     */

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public String getFirClassName() {
        return firClassName;
    }

    public void setFirClassName(String firClassName) {
        this.firClassName = firClassName;
    }

    public String getSecClassName() {
        return secClassName;
    }

    public void setSecClassName(String secClassName) {
        this.secClassName = secClassName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAdvertisement() {
        return advertisement;
    }

    public void setAdvertisement(String advertisement) {
        this.advertisement = advertisement;
    }

    public String getBooksIntroduction() {
        return booksIntroduction;
    }

    public void setBooksIntroduction(String booksIntroduction) {
        this.booksIntroduction = booksIntroduction;
    }

    public Integer getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(Integer goodsState) {
        this.goodsState = goodsState;
    }

    public String getOnSellingTime() {
        return onSellingTime;
    }

    public void setOnSellingTime(String onSellingTime) {
        this.onSellingTime = onSellingTime;
    }

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public String getIsbnNum() {
        return isbnNum;
    }

    public void setIsbnNum(String isbnNum) {
        this.isbnNum = isbnNum;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }
}
