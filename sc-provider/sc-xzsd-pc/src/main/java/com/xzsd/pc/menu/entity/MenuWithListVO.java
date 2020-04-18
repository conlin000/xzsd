package com.xzsd.pc.menu.entity;


import java.util.Date;

/**
 * 菜单（列表）查询VO实体类
 */
public class MenuWithListVO {

    // 菜单id
    private String menuId;

    // 菜单名称
    private String menuName;

    // 版本号
    private int version;


    /**
     * Setter & Getter
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
