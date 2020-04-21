package com.xzsd.pc.homePagePic.entity;


import java.util.Date;

/**
 * pc-首页轮播图实体类
 * @author Conlin
 * @date
 */
public class ImageInfo {

    // 图片编号
    private String imageCode;

    // 图片排序号
    private Integer sortNo;

    // 图片路径
    private String imagePath;

    // 有效期起
    private String effectiveOn;

    // 有效期止
    private String effectiveEnd;

    // 商品编号
    private String goodsCode;

    //  图片状态 0-禁用  1-启用
    private Integer imageState;

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
    private String version;

    // 当前页码
    private int pageNum;

    // 每一页的数据条数
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

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }

    public Integer getSortNo() {
        return sortNo;
    }

    public void setSortNo(Integer sortNo) {
        this.sortNo = sortNo;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getEffectiveOn() {
        return effectiveOn;
    }

    public void setEffectiveOn(String effectiveOn) {
        this.effectiveOn = effectiveOn;
    }

    public String getEffectiveEnd() {
        return effectiveEnd;
    }

    public void setEffectiveEnd(String effectiveEnd) {
        this.effectiveEnd = effectiveEnd;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public Integer getImageState() {
        return imageState;
    }

    public void setImageState(Integer imageState) {
        this.imageState = imageState;
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

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
