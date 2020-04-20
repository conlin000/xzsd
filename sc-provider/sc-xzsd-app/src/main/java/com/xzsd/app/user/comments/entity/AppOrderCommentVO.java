package com.xzsd.app.user.comments.entity;

import java.util.Date;
import java.util.List;

/**
 * App-新增订单评价VO
 */
public class AppOrderCommentVO {

    // 用户编码
    private String userCode;

    // 用户名称
    private String useName;

    // 订单编码
    private String orderCode;

    // 订单评价信息List
    private List<AppCommentInfoVO> commentInfoVOList;

    // 删除标记： 0-未删除  1-已删除
    private int isDeleted;

    // 创建者
    private String creator;

    // 创建时间
    private Date createTime;

    // 版本号
    private int version;


    /**
     * setter & getter
     */
    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<AppCommentInfoVO> getCommentInfoVOList() {
        return commentInfoVOList;
    }

    public void setCommentInfoVOList(List<AppCommentInfoVO> commentInfoVOList) {
        this.commentInfoVOList = commentInfoVOList;
    }

    public String getUseName() {
        return useName;
    }

    public void setUseName(String useName) {
        this.useName = useName;
    }
}
