package com.xzsd.pc.goods.entity;

/**
 * pc-新增商品的一级或二级分类查询VO
 */
public class ClassChooseVO {

    // 分类编码
    private String classCode;

    // 分类等级
    private Integer classLevel;

    // 分类名称
    private String className;

    // 父级编号
    private String parentClassCode;


    /**
     * getter & setter
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
}
