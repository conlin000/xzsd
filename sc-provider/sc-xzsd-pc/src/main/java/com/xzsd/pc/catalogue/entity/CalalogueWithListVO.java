package com.xzsd.pc.catalogue.entity;


import java.util.List;

/**
 * pc-分类（列表）查询VO实体类
 */
public class CalalogueWithListVO {

    // 一级分类编码
    private String classCode;

    // 一级分类等级
    private Integer classLevel;

    // 一级分类名称
    private String className;

    // 一级分类级父级编号
    private String parentClassCode;

    // 一级版本号
    private int version;

    // 子列表(非数据库字段)
    private List<SecClassListVO> secClass;

//    // 二级分类编码
//    private String secClassCode;
//
//    // 二级分类等级
//    private Integer secClassLevel;
//
//    // 二级分类名称
//    private String secClassName;




    /**
     * setter & getter
     */
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<SecClassListVO> getSecClass() {
        return secClass;
    }

    public void setSecClass(List<SecClassListVO> secClass) {
        this.secClass = secClass;
    }

    public String getParentClassCode() {
        return parentClassCode;
    }

    public void setParentClassCode(String parentClassCode) {
        this.parentClassCode = parentClassCode;
    }

//    public List<CalalogueWithListVO> getSecClass() {
//        return secClass;
//    }
//
//    public void setSecClass(List<CalalogueWithListVO> secClass) {
//        this.secClass = secClass;
//    }
}
