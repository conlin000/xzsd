package com.xzsd.pc.catalogue.entity;


/**
 * pc-分类详情查询VO实体类
 */
public class QueryCatalogueVO {

    // 分类名称
    private String className;

    // 备注
    private String note;

    // 版本号
    private int version;


    /**
     * setter & getter
     */
    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
