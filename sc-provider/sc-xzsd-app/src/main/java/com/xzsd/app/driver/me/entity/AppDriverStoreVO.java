package com.xzsd.app.driver.me.entity;

/**
 * app-司机端：负责门店查询VO
 */
public class AppDriverStoreVO {
    // 当前用户编码
    private String userCode;

    // 门店编号
    private String storeCode;

    // 门店名称
    private String storeName;

    // 门店地址
    private String storeAddress;

    // 店长名字
    private String userName;

    // 店长手机
    private String phone;

    /**
     * setter & getter
     */
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public void setStoreAddress(String storeAddress) {
        this.storeAddress = storeAddress;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
