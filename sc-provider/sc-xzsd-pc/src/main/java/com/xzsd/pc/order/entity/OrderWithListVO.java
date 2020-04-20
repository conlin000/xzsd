package com.xzsd.pc.order.entity;

import java.util.Date;

/**
 * pc-订单列表查询VO
 */
public class OrderWithListVO {

    // 订单编号
    private String orderCode;

    // 订单总价
    private float totalPrice;

    // 订单状态：0-订单取消 1-订单到货 2-取消到货 3-订单已取货 4-取消已取货
    private Integer orderState;

    // 支付状态（暂时忽略）
    private Integer paymentState;

    // 下单人
    private String userName;

    // 门店编码
    private String storeCode;

    // 下单人手机号
    private String phone;

    // 确认下单时间
    private String paidDate;

    // 创建时间
    private Date createTime;

    // 当前用户编码（店长只能看到自己门店的订单，管理员能看到全部）(非数据库字段,用于查询)
    private String currentUserCode;

    // 当前用户角色（店长只能看到自己门店的订单，管理员能看到全部）(非数据库字段,用于查询)
    private Integer currentUserRole;

    // 付款时间起(非数据库字段,用于查询)
    private String paidDateOn;

    // 付款时间止(非数据库字段,用于查询)
    private String paidDateEnd;

    // 版本号
    private int version;

    // 当前页码 (非数据库字段,用于查询)
    private int pageNum;

    // 一页的数据条数 (非数据库字段,用于查询)
    private int pageSize;



    /**
     * Setter & Getter
     */
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

    public Integer getOrderState() {
        return orderState;
    }

    public void setOrderState(Integer orderState) {
        this.orderState = orderState;
    }

    public Integer getPaymentState() {
        return paymentState;
    }

    public void setPaymentState(Integer paymentState) {
        this.paymentState = paymentState;
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

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCurrentUserCode() {
        return currentUserCode;
    }

    public void setCurrentUserCode(String currentUserCode) {
        this.currentUserCode = currentUserCode;
    }

    public Integer getCurrentUserRole() {
        return currentUserRole;
    }

    public void setCurrentUserRole(Integer currentUserRole) {
        this.currentUserRole = currentUserRole;
    }

    public String getPaidDateOn() {
        return paidDateOn;
    }

    public void setPaidDateOn(String paidDateOn) {
        this.paidDateOn = paidDateOn;
    }

    public String getPaidDateEnd() {
        return paidDateEnd;
    }

    public void setPaidDateEnd(String paidDateEnd) {
        this.paidDateEnd = paidDateEnd;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
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
