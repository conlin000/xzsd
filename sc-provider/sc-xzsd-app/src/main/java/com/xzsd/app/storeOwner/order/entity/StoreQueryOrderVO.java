package com.xzsd.app.storeOwner.order.entity;

import java.util.Date;
import java.util.List;

/**
 * App店长端:订单详情查询VO实体类
 */
public class StoreQueryOrderVO {

    // 订单编号
    private String orderCode;

    // 订单状态：0-已下单 1-已发货 2-已完成未评价 3-已完成已评价 4-已取消
    private String orderState;

    // 支付状态: 0-未付款 1-已付款
    private int paymentState;

    // 订单创建时间
    private Date createTime;

    // 下单人编号
    private String userCode;

    // 下单人名称
    private String userName;

    // 下单人手机
    private String phone;

    // 店长编码
    private String currentUserCode;

    // 门店编号（用于查询门店地址和名称）
    private String storeCode;

    // 门店名称（由”门店编号查询“）
    private String storeName;

    // 门店地址（由”门店编号查询“）
    private String storeAddress;

    // 订单所含商品数量
    private int goodsCount;

    // 订单总价
    private float totalPrice;

    // 购物车id串
    private String shoppingCartIdList;

    // 购物车
    private List<ShoppingCartListVO> shoppingCartList;




    /**
     * getter & setter
     */
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

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<ShoppingCartListVO> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(List<ShoppingCartListVO> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderState() {
        return orderState;
    }

    public void setOrderState(String orderState) {
        this.orderState = orderState;
    }

    public int getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(int paymentState) {
        this.paymentState = paymentState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getShoppingCartIdList() {
        return shoppingCartIdList;
    }

    public void setShoppingCartIdList(String shoppingCartIdList) {
        this.shoppingCartIdList = shoppingCartIdList;
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

    public String getCurrentUserCode() {
        return currentUserCode;
    }

    public void setCurrentUserCode(String currentUserCode) {
        this.currentUserCode = currentUserCode;
    }
}
