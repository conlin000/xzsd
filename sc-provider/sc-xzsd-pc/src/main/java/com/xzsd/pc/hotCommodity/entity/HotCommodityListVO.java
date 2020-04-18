package com.xzsd.pc.hotCommodity.entity;

import java.util.Date;
/**
 * pc-热门位商品（列表）查询VO
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

    // 书本介绍
    private String booksIntroduction;

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

    public String getBooksIntroduction() {
        return booksIntroduction;
    }

    public void setBooksIntroduction(String booksIntroduction) {
        this.booksIntroduction = booksIntroduction;
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
}
