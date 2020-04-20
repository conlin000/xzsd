package com.xzsd.app.user.shoppingCart.entity;

import java.util.Date;

/**
 * app-用户端：App购物车实体类
 */
public class ShoppingCartInfo {

    // 购物车id
    private String shoppingCartId;

    // 用户编号
    private String userCode;

    // 用户姓名
    private String userName;

    // 商品编号
    private String goodsCode;

    // 商品名称
    private String goodsName;

    // 商品图片路径
    private String imagePath;

    // 售价
    private float sellingPrice;

    // 是否已结算 ：0-未结算 1-已结算（结算后不能被查询出来）
    private int isPaid;

    // 商品数量
    private int goodsCount;

    // 总价
    private float totalPrice;

    // 当前用户id(非数据库字段)
    private String currentUserCode;

    // 当前页码（用于分页查询）(非数据库字段)
    private int pageNum;

    // 每一页的数据条数（用于分页查询）(非数据库字段)
    private int pageSize;

    // 删除标记：0-未删除  1-已删除
    private int isDeleted;

    // 创建者
    private String creator;

    // 创建时间
    private Date createTime;

    // 修改者
    private String modifiedBy;

    // 修改时间
    private Date lastModifiedTime;

    // 版本号
    private int version;


    /**
     * Getter & Setter
     */
    public String getShoppingCartId() {
        return shoppingCartId;
    }

    public void setShoppingCartId(String shoppingCartId) {
        this.shoppingCartId = shoppingCartId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getCurrentUserCode() {
        return currentUserCode;
    }

    public void setCurrentUserCode(String currentUserCode) {
        this.currentUserCode = currentUserCode;
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

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getLastModifiedTime() {
        return lastModifiedTime;
    }

    public void setLastModifiedTime(Date lastModifiedTime) {
        this.lastModifiedTime = lastModifiedTime;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public float getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(float sellingPrice) {
        this.sellingPrice = sellingPrice;
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

    public int getIsPaid() {
        return isPaid;
    }

    public void setIsPaid(int isPaid) {
        this.isPaid = isPaid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
