package com.xzsd.pc.hotCommodity.entity;

import java.util.Date;

/**
 * pc-热门位商品实体类
 */

public class HotCommodityInfo {

    // 热门商品id
    private String hotCommodityID;

    // 热门位排序号：0-无排序
    private Integer hotSortNo;

    // 商品编号
    private String goodsCode;

    // 商品名称
    private String goodsName;

    // 售价
    private float sellingPrice;

    // 书本介绍
    private String booksIntroduction;

    //删除标记： 0-未删除  1-已删除
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

    // 当前页码（非数据库字段）
    private int pageNum;

    // 一页的数据条数（非数据库字段）
    private int pageSize;


    /**
     * getter & setter
     */
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

    public String getHotCommodityID() {
        return hotCommodityID;
    }

    public void setHotCommodityID(String hotCommodityID) {
        this.hotCommodityID = hotCommodityID;
    }

    public Integer getHotSortNo() {
        return hotSortNo;
    }

    public void setHotSortNo(Integer hotSortNo) {
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

    public String getBooksIntroduction() {
        return booksIntroduction;
    }

    public void setBooksIntroduction(String booksIntroduction) {
        this.booksIntroduction = booksIntroduction;
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

}
