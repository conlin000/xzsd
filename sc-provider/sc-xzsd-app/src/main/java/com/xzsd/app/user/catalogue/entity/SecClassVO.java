package com.xzsd.app.user.catalogue.entity;

import java.util.List;

/**
 * app-用户端：二级分类商品VO
 */
public class SecClassVO {

    // 父级编码
    private String parentClassCode;

    // 二级分类编码
    private String secClassCode;

    // 分类名称
    private String className;

    // 分类等级
    private int classLevel;

    //二级分类商品
    List<ViewCommodityVO> secClassGoodsVO;




    /**
     * Setter & Getter
     */
    public String getParentClassCode() {
        return parentClassCode;
    }

    public void setParentClassCode(String parentClassCode) {
        this.parentClassCode = parentClassCode;
    }

    public String getSecClassCode() {
        return secClassCode;
    }

    public void setSecClassCode(String secClassCode) {
        this.secClassCode = secClassCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public int getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(int classLevel) {
        this.classLevel = classLevel;
    }

    public List<ViewCommodityVO> getSecClassGoodsVO() {
        return secClassGoodsVO;
    }

    public void setSecClassGoodsVO(List<ViewCommodityVO> secClassGoodsVO) {
        this.secClassGoodsVO = secClassGoodsVO;
    }
}
