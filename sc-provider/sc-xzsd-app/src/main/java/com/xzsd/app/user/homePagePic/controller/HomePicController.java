package com.xzsd.app.user.homePagePic.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.user.homePagePic.entity.HotCommodityListVO;
import com.xzsd.app.user.homePagePic.entity.ImagesWithListVO;
import com.xzsd.app.user.homePagePic.service.HomePicService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/homePagePic")

public class HomePicController {


    @Resource
    private HomePicService homePicService;


    // spring boot 自带日志
    private static final Logger logger = LoggerFactory.getLogger(HomePicController.class);



    /**
     * APP首页轮播图查询(分页查询)
     * @description APP首页轮播图查询(分页查询)
     * @function homePicWithList
     * @param imagesWithListVO (pageNum, pageSize)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("homePicWithList")
    public AppResponse homePicWithList(ImagesWithListVO imagesWithListVO){
        try {
            return homePicService.homePicWithList(imagesWithListVO);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * APP首页热品位商品查询(分页查询)
     * @description APP首页热品位商品查询(分页查询)
     * @function hotCommodityWithList
     * @param hotCommodityListVO (pageNum, pageSize)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("hotCommodityWithList")
    public AppResponse hotCommodityWithList(HotCommodityListVO hotCommodityListVO){
        try {
            return homePicService.hotCommodityWithList(hotCommodityListVO);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
