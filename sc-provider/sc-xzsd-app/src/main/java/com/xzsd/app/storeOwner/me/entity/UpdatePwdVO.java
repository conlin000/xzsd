package com.xzsd.app.storeOwner.me.entity;

/**
 * 修改密码VO实体类
 */
public class UpdatePwdVO {

    // 用户id
    private String userId;

    // 原用户密码
    private String password;

    // 新密码
    private String newPassword;

    // 确认密码
    private String confirmPwd;

    // 修改店铺邀请码
    private String inviteCode;


    /**
     * setter & Getter
     */
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getConfirmPwd() {
        return confirmPwd;
    }

    public void setConfirmPwd(String confirmPwd) {
        this.confirmPwd = confirmPwd;
    }

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
