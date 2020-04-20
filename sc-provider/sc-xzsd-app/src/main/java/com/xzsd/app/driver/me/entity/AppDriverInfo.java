package com.xzsd.app.driver.me.entity;

/**
 * app-司机端：个人信息实体类
 */
public class AppDriverInfo {

    // 司机编号
    private String driverCode;

    // 头像
    private String imagePath;

    // 司机名称
    private String driverName;

    // 司机号码
    private String phone;


    /**
     * getter & setter
     */
    public String getDriverCode() {
        return driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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
