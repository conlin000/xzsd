package com.xzsd.pc.menu.entity;


/**
 * 菜单详情查询OV实体类
 */
public class QueryMenuVO {

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

    // 版本号
    private int version;


    /**
     * setter & getter
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
