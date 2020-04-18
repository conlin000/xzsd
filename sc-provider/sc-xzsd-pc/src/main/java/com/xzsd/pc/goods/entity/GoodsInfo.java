package com.xzsd.pc.goods.entity;


import java.util.Date;

/**
 * 商品实体类
 * @author Conlin
 * @date
 */

public class GoodsInfo {


    // 商品编码
    private String goodsCode;

    // 商品名字
    private String goodsName;

    // isbn书号
    private String isbnNum;

    // 一级分类编码
    private String firClassCode;

    // 二级分类编码
    private String secClassCode;

    // 广告词
    private String advertisement;

    // 书本介绍
    private String booksIntroduction;

    // 售价
    private float sellingPrice;

    // 定价
    private float costPrice;

    // 销售量
    private int sales;

    // 库存
    private int stock;

    // 商品预览图路径
    private String goodsImages;

    // 商品评分： 0~2差评  3~4中评  5好评
    private float goodsScore;

    // 商品状态：0-在售  1-已下架  2-未发布
    private Integer goodsState;

    // 上架时间
    private Date onSellingTime;

    // 浏览量
    private Integer views;

    // 作者
    private String author;

    // 出版社
    private String press;

    // 删除标记：0-未删除  1-已删除
    private int isDeleted;

    // 创建者
    private String creator;

    // 创建时间
    private Date createTime;

    // 修改者
    private String modifiedBy;

    // 修改时间
    private Date lastModifiedTime;

    // 版本号
    private int version;

    // 当前页码
    private int pageNum;

    // 一页的数据条数
    private int pageSize;



    /**
     * Setter & Getter
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

    public String getSecClassCode() {
        return secClassCode;
    }

    public void setSecClassCode(String secClassCode) {
        this.secClassCode = secClassCode;
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

    public int getSales() {
        return sales;
    }

    public void setSales(int sales) {
        this.sales = sales;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getGoodsImages() {
        return goodsImages;
    }

    public void setGoodsImages(String goodsImages) {
        this.goodsImages = goodsImages;
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

    public Integer getViews() {
        return views;
    }

    public void setViews(Integer views) {
        this.views = views;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPress() {
        return press;
    }

    public void setPress(String press) {
        this.press = press;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
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
}
