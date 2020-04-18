package com.xzsd.pc.catalogue.entity;


import java.util.List;

/**
 * pc-分类（列表）查询VO实体类
 */
public class CalalogueWithListVO {

    // 分类编码
    private String classCode;

    // 分类等级
    private Integer classLevel;

    // 分类名称
    private String className;

    // 父级编号
    private String parentClassCode;

    // 版本号
    private int version;

    // 子列表(非数据库字段)
    private List<CalalogueWithListVO> secClass;

//    // 子列表(非数据库字段)递归法
//    private List<CalalogueWithListVO> son;

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

    public List<CalalogueWithListVO> getSecClass() {
        return secClass;
    }

    public void setSecClass(List<CalalogueWithListVO> secClass) {
        this.secClass = secClass;
    }
    //    public List<CalalogueWithListVO> getSon() {
//        return son;
//    }
//
//    public void setSon(List<CalalogueWithListVO> son) {
//        this.son = son;
//    }
}
