package com.xzsd.app.user.comments.entity;

import java.util.Date;

/**
 * app-用户端：评价列表VO实体类
 */
public class CommentWithListVO {

    // 商品评论编号
    private String commentCode;

    // 用户编码（通过用户编码查询用户名称）
    private String userCode;

    // 用户名称
    private String userName;

    // 评论内容
    private String comment;

    // 商品编号（通过商品编码查询商品评分）
    private String goodsCode;

    // 商品评分 0~2星差评  2~4星中评  5星好评
    private float goodsScore;

    // 创建时间
    private String createTime;

//    // 当前页码
//    private int pageNum;
//
//    // 每一页的数据条数
//    private int pageSize;



    /**
     * Setter & Getter
     */
    public String getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(String commentCode) {
        this.commentCode = commentCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public float getGoodsScore() {
        return goodsScore;
    }

    public void setGoodsScore(float goodsScore) {
        this.goodsScore = goodsScore;
    }
}
