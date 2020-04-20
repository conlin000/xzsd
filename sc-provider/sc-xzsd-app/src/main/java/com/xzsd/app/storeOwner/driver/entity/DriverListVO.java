package com.xzsd.app.storeOwner.driver.entity;

/**
 * App店长端:司机（列表）查询VO
 */
public class DriverListVO {

    // 当前用户
    private String currentUserCode;

    // 司机编号
    private String driverCode;

    // 司机名称
    private String driverName;

    // 司机手机
    private String phone;

    /**
     * setter & getter
     */
    public String getCurrentUserCode() {
        return currentUserCode;
    }

    public void setCurrentUserCode(String currentUserCode) {
        this.currentUserCode = currentUserCode;
    }

    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
