package com.xzsd.pc.customer.entity;


/**
 * 客户实体类
 * @author Conlin
 * @date
 */
public class CustomerInfo {

    // 用户角色（管理员能看到所有客户，店长只能看到自己的客户和司机）(非数据库字段)
    private String userRole;

    // 用户账号
    private String userAccount;

    // 用户名称
    private String userName;

    // 用户性别：0-女  1-男
    private Integer sex;

    // 手机号码
    private String phone;

    // 邮箱
    private String email;

    // 身份证
    private String idCard;

    // 当前用户id
    private String currentUserCode;

    // 当前页码(非数据库字段)
    private int pageNum;

    // 一页的数据条数(非数据库字段)
    private int pageSize;


    /**
     * Getter & Setter
     */
    public String getUserRole() {
        return userRole;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
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

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getCurrentUserCode() {
        return currentUserCode;
    }

    public void setCurrentUserCode(String currentUserCode) {
        this.currentUserCode = currentUserCode;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
