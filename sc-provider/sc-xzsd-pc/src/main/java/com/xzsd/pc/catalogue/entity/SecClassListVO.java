package com.xzsd.pc.catalogue.entity;
/**
 * pc-二级分类（列表）查询VO实体类
 */
public class SecClassListVO {
//
//    // 二级分类编码
//    private String SecClassCode;
//
//    // 二级类等级
//    private Integer SecClassLevel;
//
//    // 二级分类名称
//    private String SecClassName;
//
//    // 二级分类级父级编号
//    private String parentClassCode;
//
//    // 二级版本号
//    private int version2;
//
//
//
//    /**
//     *
//     * getter & setter
//     */
//    public String getSecClassCode() {
//        return SecClassCode;
//    }
//
//    public void setSecClassCode(String secClassCode) {
//        SecClassCode = secClassCode;
//    }
//
//    public Integer getSecClassLevel() {
//        return SecClassLevel;
//    }
//
//    public void setSecClassLevel(Integer secClassLevel) {
//        SecClassLevel = secClassLevel;
//    }
//
//    public String getSecClassName() {
//        return SecClassName;
//    }
//
//    public void setSecClassName(String secClassName) {
//        SecClassName = secClassName;
//    }
//
//    public String getParentClassCode() {
//        return parentClassCode;
//    }
//
//    public void setParentClassCode(String parentClassCode) {
//        this.parentClassCode = parentClassCode;
//    }
//
//    public int getVersion2() {
//        return version2;
//    }
//
//    public void setVersion2(int version2) {
//        this.version2 = version2;
//    }




    // 二级分类编码
    private String classCode;

    // 二级类等级
    private Integer classLevel;

    // 二级分类名称
    private String className;

    // 二级分类级父级编号
    private String parentClassCode;

    // 二级版本号
    private int version;


    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }

    public Integer getClassLevel() {
        return classLevel;
    }

    public void setClassLevel(Integer classLevel) {
        this.classLevel = classLevel;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getParentClassCode() {
        return parentClassCode;
    }

    public void setParentClassCode(String parentClassCode) {
        this.parentClassCode = parentClassCode;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
