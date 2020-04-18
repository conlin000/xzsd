package com.xzsd.pc.driver.entity;

/**
 * pc-司机新增：省市区VO实体类
 */
public class PlaceVO {

    // 地级编号
    private String palceCode;

    // 父地级编号
    private String parentPlaceCode;

    // 地级等级：1-省  2-市  3-区
    private int placeLevel;

    // 地级名称
    private String placeName;


    /**
     * setter & getter
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

    public int getPlaceLevel() {
        return placeLevel;
    }

    public void setPlaceLevel(int placeLevel) {
        this.placeLevel = placeLevel;
    }

    public String getPlaceName() {
        return placeName;
    }

    public void setPlaceName(String placeName) {
        this.placeName = placeName;
    }
}
