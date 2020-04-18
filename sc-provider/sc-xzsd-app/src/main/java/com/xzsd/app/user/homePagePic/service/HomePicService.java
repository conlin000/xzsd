package com.xzsd.app.user.homePagePic.service;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.user.homePagePic.dao.HomePicDao;
import com.xzsd.app.user.homePagePic.entity.HotCommodityListVO;
import com.xzsd.app.user.homePagePic.entity.ImagesWithListVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class HomePicService {


    @Resource
    private HomePicDao homePicDao;



    /**
     * APP首页轮播图查询
     * @description APP首页轮播图查询
     * @function homePicWithList
     * @param imagesWithListVO
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse homePicWithList(ImagesWithListVO imagesWithListVO){
        // APP首页轮播图查询
        List<ImagesWithListVO> imagesWithListVOList = homePicDao.homePicWithList(imagesWithListVO);
        return AppResponse.success("查询成功", imagesWithListVOList);
    }



    /**
     * APP首页热品位商品查询
     * @description APP首页热品位商品查询
     * @function hotCommodityWithList
     * @param hotCommodityListVO
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse hotCommodityWithList(HotCommodityListVO hotCommodityListVO){
        // APP首页热品位商品查询
        List<HotCommodityListVO> hotCommodityListVOList = homePicDao.hotCommodityWithList(hotCommodityListVO);
        return AppResponse.success("查询成功", hotCommodityListVOList);
    }
}
