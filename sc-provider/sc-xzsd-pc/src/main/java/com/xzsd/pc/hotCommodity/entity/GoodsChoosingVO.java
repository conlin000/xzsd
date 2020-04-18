package com.xzsd.pc.hotCommodity.entity;


/**
 * 热门商品位新增 - 商品选择实体类
 * @author Conlin
 * @date
 */
public class GoodsChoosingVO {

    // 商品编码
    private String goodsCode;

    // 商品名字
    private String goodsName;

    // 商品状态：0-在售  1-已下架  2-未发布
    private int goodsState;

    // 一级分类编码
    private String firClassCode;

    // 二级分类编码
    private String secClassCode;

    // 当前页码
    private int pageNum;

    // 一页的数据条数
    private int pageSize;

    /**
     * getter & setter
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

    public int getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(int goodsState) {
        this.goodsState = goodsState;
    }

    public String getFirClassCode() {
        return firClassCode;
    }

    public void setFirClassCode(String firClassCode) {
        this.firClassCode = firClassCode;
    }

    public String getSecClassCode() {
        return secClassCode;
    }

    public void setSecClassCode(String secClassCode) {
        this.secClassCode = secClassCode;
    }
}
