package com.xzsd.app.storeOwner.order.entity;

import java.util.List;

/**
 * App店长端:订单（列表）查询VO实体类
 */
public class OrderListVO {

    // 当前用户id(店长用于查询自己的门店)（非数据库字段）
    private String currentUserCode;

    // 门店编号
    private String storeCode;

    // 订单编号
    private String orderCode;

    // 购物车id
    private String shoppingCartId;

    // 订单状态：0-已下单 1-已发货 2-已完成未评价 3-已完成已评价 4-已取消
    private String orderState;

    // 支付状态: 0-未付款 1-已付款
    private int paymentState;

    // 订单所含商品数量
    private int goodsCount;

    // 订单总价
    private float totalPrice;

    // 关键字（列表查询条件）（非数据库字段）
    private String keyWord;

    // 购物车（非数据库字段）
    private List<ShoppingCartListVO> shoppingCartList;

    // 下单人编号(用于查询)
    private String userCode;

    // 下单人名字(用于查询)
    private String userName;

    // 下单人手机(用于查询)
    private String phone;

//    // 当前页码(用于分页查询)（非数据库字段）
//    private int pageNum;
//
//    // 一页的数据条数(用于分页查询)（非数据库字段）
//    private int pageSize;

    /**
     * setter & getter
     */
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

//    public int getPageNum() {
//        return pageNum;
//    }
//
//    public void setPageNum(int pageNum) {
//        this.pageNum = pageNum;
//    }
//
//    public int getPageSize() {
//        return pageSize;
//    }
//
//    public void setPageSize(int pageSize) {
//        this.pageSize = pageSize;
//    }

    public List<ShoppingCartListVO> getShoppingCartList() {
        return shoppingCartList;
    }

    public void setShoppingCartList(List<ShoppingCartListVO> shoppingCartList) {
        this.shoppingCartList = shoppingCartList;
    }

    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getCurrentUserCode() {
        return currentUserCode;
    }

    public void setCurrentUserCode(String currentUserCode) {
        this.currentUserCode = currentUserCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
    }
}
