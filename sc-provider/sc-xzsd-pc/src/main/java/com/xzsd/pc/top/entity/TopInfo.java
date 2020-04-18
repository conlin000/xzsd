package com.xzsd.pc.top.entity;

/**
 * 顶部栏实体类
 */
public class TopInfo {
    // 当前用户编码
    private String currentUserCode;

    // 用户名称
    private String useName;

    // 用户头像图片
    private String imagePath;

    // 用户角色
    private String role;

    /**
     * getter & setter
     */
    public String getCurrentUserCode() {
        return currentUserCode;
    }

    public void setCurrentUserCode(String currentUserCode) {
        this.currentUserCode = currentUserCode;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
