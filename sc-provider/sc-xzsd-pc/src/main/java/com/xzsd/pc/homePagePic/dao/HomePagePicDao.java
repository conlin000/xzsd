package com.xzsd.pc.homePagePic.dao;

import com.xzsd.pc.homePagePic.entity.GoodsChoosingVO;
import com.xzsd.pc.homePagePic.entity.ImageInfo;
import com.xzsd.pc.homePagePic.entity.ImagesWithListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HomePagePicDao {


    /**
     * 首页轮播图新增
     * @description 首页轮播图新增
     * @function addHomePagePic
     * @tpye&return int
     * @param imageInfo (imagePath, sortNo, effectiveOn, effectiveEnd, goodsCode)
     * @author Conlin
     * @date
     */
    int addHomePagePic(ImageInfo imageInfo);



    /**
     * 检查商品数量
     * @description 一个商品只能有一个首页轮播图
     * @function checkGoods
     * @tpye&return int
     * @param goodsCode
     * @author Conlin
     * @date
     */
    int checkGoods(String goodsCode);

    /**
     * 检查排序号
     * @description 检查排序号是否存在，若不存在应返回“0”
     * @function checkSortNo
     * @tpye&return int
     * @param sortNo
     * @author Conlin
     * @date
     */
    int checkSortNo(int sortNo);



    /**
     * pc-首页轮播图新增 ==> 商品选择(分页查询)
     * @description 首页轮播图新增的“商品选择”(分页查询)
     * @function goodsChoosing
     * @tpye&return List<GoodsChoosingVO>
     * @param goodsChoosingVO
     * @author Conlin
     * @date
     */
    List<GoodsChoosingVO> goodsChoosing(GoodsChoosingVO goodsChoosingVO);


    /**
     * 首页轮播图删除
     * @description 首页轮播图删除，通过图片的id删除
     * @function removeHomePagePic
     * @tpye&return int
     * @param imageCode, userId
     * @author Conlin
     * @date
     */
    int removeHomePagePic(@Param("imageCode") List<String> imageCode, @Param("userId") String userId);


    /**
     * 首页轮播图状态修改
     * @description 首页轮播图状态修改，通过图片的id修改。图片状态 0-禁用  1-启用
     * @function updatePicState
     * @tpye&return int
     * @param imageInfo
     * @author Conlin
     * @date
     */
    int updatePicState(ImageInfo imageInfo);


    /**
     * 首页轮播图（列表）查询
     * @description 首页轮播图（列表）查询(分页查询)
     * @function imagesWithList
     * @tpye&return int
     * @param imageInfo
     * @author Conlin
     * @date
     */
    List<ImagesWithListVO> imagesWithList(ImagesWithListVO imageInfo);
}
