package com.xzsd.pc.menu.entity;

/**
 * 根据角色返回菜单选项（列表）查询VO
 */
public class MenuByRoleVO {

    // 用户角色
    private Integer role;

    // 菜单id
    private String menuId;

    // 菜单名称
    private String menuName;

    // 版本号
    private int version;


    /**
     * Setter & Getter
     */
    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }

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
