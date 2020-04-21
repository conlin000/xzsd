package com.xzsd.pc.order.entity;

import java.util.Date;

/**
 * pc-订单实体类
 */
public class OrderInfo {

    // 订单编号
    private String orderCode;

    // 订单总价
    private float totalPrice;

    // 订单状态：0-订单取消 1-订单到货 2-取消到货 3-订单已取货 4-取消已取货
    private int orderState;

    // 支付状态（暂时忽略）
    private int paymentState;

    // 店铺编号
    private String storeCode;

    // 用户编号
    private String userCode;

    // 下单人
    private String userName;

    // 下单人手机号
    private String phone;

    // 确认下单时间
    private String paidDate;

    // 购物车id（通过购物车id查询商品的信息）
    private String shoppingCartId;

    // 删除标记： 0-未删除  1-已删除
    private int isDeleted;

    // 创建者
    private String creator;

    // 创建时间
    private Date createTime;

    // 修改者
    private String lastModifiedBy;

    // 修改时间
    private Date modifiedTime;

    // 版本号
    private String version;

    // 当前页码(非数据库字段)
    private int pageNum;

    // 一页的数据条数(非数据库字段)
    private int pageSize;


    /**
     * setter & getter
     */
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

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public int getOrderState() {
        return orderState;
    }

    public void setOrderState(int orderState) {
        this.orderState = orderState;
    }

    public int getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(int paymentState) {
        this.paymentState = paymentState;
    }

    public String getStoreCode() {
        return storeCode;
    }

    public void setStoreCode(String storeCode) {
        this.storeCode = storeCode;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPaidDate() {
        return paidDate;
    }

    public void setPaidDate(String paidDate) {
        this.paidDate = paidDate;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getLastModifiedBy() {
        return lastModifiedBy;
    }

    public void setLastModifiedBy(String lastModifiedBy) {
        this.lastModifiedBy = lastModifiedBy;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }
}
