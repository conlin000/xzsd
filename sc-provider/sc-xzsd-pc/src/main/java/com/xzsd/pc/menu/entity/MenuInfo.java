package com.xzsd.pc.menu.entity;


import java.util.Date;

/**
 * 菜单实体类
 * @author Conlin
 * @date
 */
public class MenuInfo {


    // 菜单id
    private String menuId;

    // 菜单名称
    private String menuName;

    // 菜单等级 0-目录  1-菜单
    private Integer menuLevel;

    // 路径
    private String menuPath;

    // 备注
    private String comments;

    // 删除标志：0-未删除  1-已删除
    private int isDeleted;

    // 创建时间
    private Date createTime;

    // 创建者
    private String creator;

    // 修改时间
    private Date modifiedTime;

    // 修改者
    private String lastModifiedBy;

    // 版本号
    private int version;


    /**
     * Getter & Setter
     */
    public String getMenuId() {
        return menuId;
    }

    public void setMenuId(String menuId) {
        this.menuId = menuId;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public Integer getMenuLevel() {
        return menuLevel;
    }

    public void setMenuLevel(Integer menuLevel) {
        this.menuLevel = menuLevel;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}

