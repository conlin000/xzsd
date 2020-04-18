package com.xzsd.pc.homePagePic.entity;


import java.util.Date;

/**
 * pc-图片（列表）查询VO实体类
 */
public class ImagesWithListVO {

    // 图片编号
    private String imageCode;

    // 图片排序号
    private Integer sortNo;

    // 图片路径
    private String imagePath;

    //  图片状态 0-禁用  1-启用
    private Integer imageState;

    // 有效期起
    private String effectiveOn;

    // 有效期止
    private String effectiveEnd;

    // 创建时间
    private Date createTime;

    // 版本号
    private int version;

    // 当前页码
    private int pageNum;

    // 每一页的数据条数
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

    public Integer getImageState() {
        return imageState;
    }

    public void setImageState(Integer imageState) {
        this.imageState = imageState;
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

    public String getImageCode() {
        return imageCode;
    }

    public void setImageCode(String imageCode) {
        this.imageCode = imageCode;
    }
}
