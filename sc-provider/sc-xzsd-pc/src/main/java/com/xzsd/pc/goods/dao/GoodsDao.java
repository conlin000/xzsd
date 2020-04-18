package com.xzsd.pc.goods.dao;



import com.xzsd.pc.goods.entity.ClassChooseVO;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.GoodsWithListVO;
import com.xzsd.pc.goods.entity.QueryGoodsVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 *
 */


@Mapper
public interface GoodsDao {


    /**
     * 检查书名
     * @description 检查书本名字，防止添加相同名字的书
     * @function checkBookName
     * @tpye&return int
     * @param goodsInfo
     * @author Conlin
     * @date
     */
    int checkBookName(GoodsInfo goodsInfo);

    /**
     * 检查ISBN书号
     * @description 检查ISBN书号，若存在则是错误，返回“1”
     * @function checkISBN
     * @tpye&return int
     * @param goodsInfo (isbnNum)
     * @author Conlin
     * @date
     */
    int checkISBN(GoodsInfo goodsInfo);



    /**
     * 商品新增
     * @description 新增商品
     * @function addGoods
     * @tpye&return int
     * @param goodsInfo
     * @author Conlin
     * @date
     */
    int addGoods(GoodsInfo goodsInfo);


    /**
     *商品删除
     * @description 删除商品
     * @function removeGoods
     * @tpye&return int
     * @param goodsCodeList, userId（userCode用户记录日志）
     * @author Conlin
     * @date
     */
    int removeGoods(@Param("goodsCodeList") List<String> goodsCodeList, @Param("userId") String userId);

    /**
     *检查商品是否可删除
     * @description 检查商品是否可删除，如果没有包含“热门位商品”或者“首页轮播图”则返回“0”
     * @function checkGoods
     * @tpye&return int
     * @param goodsCodeList, userId（userCode用户记录日志）
     * @author Conlin
     * @date
     */
    int checkGoods(@Param("goodsCodeList") List<String> goodsCodeList);


    /**
     * 商品（列表）查询
     * @description 商品查询，使用到分页查询
     * @function goodsWithList
     * @tpye&return GoodsInfo
     * @param goodsInfo
     * @author Conlin
     * @date
     */
    List<GoodsWithListVO> goodsWithList(GoodsWithListVO goodsInfo);


    /**
     * 商品详情查询
     * @description 商品详情查询
     * @function queryGoods
     * @tpye&return GoodsInfo
     * @param goodsCode
     * @author Conlin
     * @date
     */
    QueryGoodsVO queryGoods(String goodsCode);


    /**
     * 商品信息修改
     * @description 商品详情查询
     * @function updateGoods
     * @tpye&return int
     * @param goodsInfo
     * @author Conlin
     * @date
     */
    int updateGoods(GoodsInfo goodsInfo);


    /**
     * 修改商品状态
     * @description 商品状态：0-在售  1-已下架  2-未发布
     * @function changeGoodsState
     * @tpye&return int
     * @param goodsInfo
     * @author Conlin
     * @date
     */
    int changeGoodsState(GoodsInfo goodsInfo);


    /**
     * 一级分类下拉查询
     * @description 新增商品时的一级分类查询接口
     * @function firClassChoosing
     * @tpye&return List<ClassChooseVO>
     * @param classChooseVO
     * @author Conlin
     * @date
     */
    List<ClassChooseVO> firClassChoosing(ClassChooseVO classChooseVO);


    /**
     * 二级分类下拉查询
     * @description 新增商品时的二级分类查询接口
     * @function secClassChoosing
     * @tpye&return List<ClassChooseVO>
     * @param parentClassCode
     * @author Conlin
     * @date
     */
    List<ClassChooseVO> secClassChoosing(String parentClassCode);
}
