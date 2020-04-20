package com.xzsd.app.user.catalogue.entity;

/**
 * app-用户端：一级分类VO实体类
 */
public class FirClassVO {

    // 一级分类编码
    private String firClassCode;

    // 分类名称
    private String className;

    // 分类等级
    private int classLevel;


    /**
     * Setter & Getter
     */
    public String getFirClass() {
        return firClassCode;
    }

    public void setFirClass(String firClass) {
        this.firClassCode = firClass;
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
}
