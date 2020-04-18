package com.xzsd.pc.user.entity;

import java.util.Date;

/**
 * pc-用户列表查询（分页查询）VO实体类
 */
public class UserWithListVO {

    // 用户编码
    private String userId;

    // 用户账号
    private String userAccount;

    // 用户名称
    private String userName;

    /*
       用户角色：0-管理员 1-店长 2-司机 3-普通用户
   */
    private Integer userRole;

    // 用户性别：0-女  1-男
    private int sex;

    // 手机号码
    private String phone;

    // 邮箱
    private String email;

    // 身份证
    private String idCard;

    // 当前页码
    private int pageNum;

    // 一页的数据条数
    private int pageSize;

    // 创建时间
    private Date createTime;

    // 删除标记：0-未删除  1-已删除
    private int isDelete;

    // 版本号
    private int version;


    /**
     * setter & Getter
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getUserRole() {
        return userRole;
    }

    public void setUserRole(Integer userRole) {
        this.userRole = userRole;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
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
