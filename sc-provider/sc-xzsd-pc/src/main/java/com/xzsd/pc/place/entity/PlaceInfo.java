package com.xzsd.pc.place.entity;

import java.util.Date;

/**
 * 地方地址实体类
 */

public class PlaceInfo {

    // 地级编号
    private String palceCode;

    // 父地级编号
    private String parentPlaceCode;

    // 地级等级：1-省  2-市  3-区
    private Integer placeLevel;

    // 地级名称
    private String placeName;

    // 删除标记： 0-未删除  1-已删除
    private int isDeleted;

    // 创建者
    private String creator;

    // 创建时间
    private Date createTime;

    // 修改者
    private String lastModifiedBy;

    // 修改时间
    private Date modifiedTime;

    // 版本号
    private int version;


    /**
     * Setter & Getter
     */
    public String getPalceCode() {
        return palceCode;
    }

    public void setPalceCode(String palceCode) {
        this.palceCode = palceCode;
    }

    public String getParentPlaceCode() {
        return parentPlaceCode;
    }

    public void setParentPlaceCode(String parentPlaceCode) {
        this.parentPlaceCode = parentPlaceCode;
    }

    public Integer getPlaceLevel() {
        return placeLevel;
    }

    public void setPlaceLevel(Integer placeLevel) {
        this.placeLevel = placeLevel;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
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

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
