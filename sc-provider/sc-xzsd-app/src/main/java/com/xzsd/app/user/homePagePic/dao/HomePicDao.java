package com.xzsd.app.user.homePagePic.dao;

import com.xzsd.app.user.homePagePic.entity.HotCommodityListVO;
import com.xzsd.app.user.homePagePic.entity.ImagesWithListVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface HomePicDao {


    /**
     * APP首页轮播图查询(分页查询)
     * @description APP首页轮播图查询(分页查询)
     * @function homePicWithList
     * @param imagesWithListVO
     * @type&return int
     * @author Conlin
     * @date
     */
    List<ImagesWithListVO> homePicWithList(ImagesWithListVO imagesWithListVO);



    /**
     * APP首页热品位商品查询(分页查询)
     * @description APP首页热品位商品查询(分页查询)
     * @function hotCommodityWithList
     * @param hotCommodityListVO
     * @type&return int
     * @author Conlin
     * @date
     */
    List<HotCommodityListVO> hotCommodityWithList(HotCommodityListVO hotCommodityListVO);

}
