package com.xzsd.app.user.comments.entity;

import java.util.List;

/**
 * app-订单评价信息VO
 */
public class AppCommentInfoVO {
    // 评论编码
    private String commentCode;

    // 订单所含的商品编号
    private String goodsCode;

    // 评价分数
    private Integer score;

    // 评价信息
    private String comment;

    // 评价图片
    private List<String> imagePath;

    /**
     * setter & getter
     */
    public String getGoodsCode() {
        return goodsCode;
    }

    public void setGoodsCode(String goodsCode) {
        this.goodsCode = goodsCode;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public List<String> getImagePath() {
        return imagePath;
    }

    public void setImagePath(List<String> imagePath) {
        this.imagePath = imagePath;
    }

    public String getCommentCode() {
        return commentCode;
    }

    public void setCommentCode(String commentCode) {
        this.commentCode = commentCode;
    }
}
