package com.xzsd.pc.user.entity;


/**
 * pc-用户详情查询VO实体类
 */
public class QueryUserVO {

    // 用户id
    private String userId;

    // 用户账号
    private String userAccount;

    // 用户密码
    private String password;

    // 用户名称
    private String userName;

    // 用户性别：0-女  1-男
    private Integer sex;

    // 身份证
    private String idCard;

    // 手机号码
    private String phone;

    // 邮箱
    private String email;

    // 删除标记：0-未删除  1-已删除
    private int isDelete;

    // 版本号
    private int version;


    /**
     * Setter & Getter
     */
    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}