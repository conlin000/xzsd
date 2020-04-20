package com.xzsd.app.storeOwner.me.entity;

/**
 * app-店长端：店长VO
 */
public class StoreOwnerVO {

    // 店长编号
    private String userCode;

    // 头像
    private String imagePath;

    // 店长名称
    private String userName;

    // 店长手机
    private String phone;

    // 门店编号（用于查询门店地址和名称）
    private String storeCode;

    // 门店名称（由”门店编号查询“）
    private String storeName;

    // 邀请码
    private String inviteCode;

    // 门店地址（由”门店编号查询“）
    private String storeAddress;


    /**
     * setter & getter
     */
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
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

    public String getInviteCode() {
        return inviteCode;
    }

    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}
