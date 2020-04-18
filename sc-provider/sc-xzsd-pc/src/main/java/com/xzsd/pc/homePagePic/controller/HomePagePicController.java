package com.xzsd.pc.homePagePic.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.homePagePic.entity.GoodsChoosingVO;
import com.xzsd.pc.homePagePic.entity.ImageInfo;
import com.xzsd.pc.homePagePic.entity.ImagesWithListVO;
import com.xzsd.pc.homePagePic.service.HomePagePicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/homePagePic")
public class HomePagePicController {


    // 日志spring boot自带
    private static final Logger logger = LoggerFactory.getLogger(HomePagePicController.class);


    @Resource
    private HomePagePicService homePagePicService;


    /**
     * 首页轮播图新增
     * @description 首页轮播图新增
     * @function addHomePagePic
     * @tpye&return AppResponse
     * @param imageInfo (imagePath, sortNo, effectiveOn, effectiveEnd, goodsCode)
     * @author Conlin
     * @date
     */
    @PostMapping("addHomePagePic")
    public AppResponse addHomePagePic(ImageInfo imageInfo){
        try{
            // 新增首页轮播图
            return homePagePicService.addHomePagePic(imageInfo);
        }catch (Exception e){
            logger.error("新增图片失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 商品选择(分页查询)
     * @description 首页轮播图新增的“商品选择”(分页查询)
     * @function goodsChoosing
     * @tpye&return
     * @param goodsInfo
     * @author Conlin
     * @date
     */
    @PostMapping("goodsChoosing")
    public AppResponse goodsChoosing(GoodsChoosingVO goodsInfo){
        try{

            return homePagePicService.goodsChoosing(goodsInfo);
        }catch (Exception e){

            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 首页轮播图删除
     * @description 首页轮播图删除，通过图片的id删除
     * @function removeHomePagePic
     * @tpye&return AppResponse
     * @param imageCode
     * @author Conlin
     * @date
     */
    @PostMapping("removeHomePagePic")
    public AppResponse removeHomePagePic(String imageCode){
        try {
            return homePagePicService.removeHomePagePic(imageCode);
        }catch (Exception e){

            logger.error("删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 首页轮播图状态修改
     * @description 首页轮播图状态修改，通过图片的id修改。图片状态 0-禁用  1-启用
     * @function updatePicState
     * @tpye&return int
     * @param imageInfo (imageCode, imageState, version)
     * @author Conlin
     * @date
     */
    @PostMapping("updatePicState")
    public AppResponse updatePicState(ImageInfo imageInfo){
        try {

            return homePagePicService.updatePicState(imageInfo);
        }catch (Exception e){
            logger.error("修改状态失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 首页轮播图（列表）查询
     * @description 首页轮播图（列表）查询(分页查询)
     * @function imagesWithList
     * @tpye&return AppResponse
     * @param imageInfo
     * @author Conlin
     * @date
     */
    @PostMapping("imagesWithList")
    public AppResponse imagesWithList(ImagesWithListVO imageInfo){
        try {
            return homePagePicService.imagesWithList(imageInfo);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
