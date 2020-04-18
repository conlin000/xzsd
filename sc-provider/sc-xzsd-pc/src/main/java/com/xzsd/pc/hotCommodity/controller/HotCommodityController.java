package com.xzsd.pc.hotCommodity.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.hotCommodity.entity.GoodsChoosingVO;
import com.xzsd.pc.hotCommodity.entity.HotCommodityInfo;
import com.xzsd.pc.hotCommodity.entity.HotCommodityListVO;
import com.xzsd.pc.hotCommodity.service.HotCommodityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/hotCommodity")
public class HotCommodityController {


    @Resource
    private HotCommodityService hotCommodityService;


    // 日志spring boot自带
    private static final Logger logger = LoggerFactory.getLogger(HotCommodityController.class);


    /**
     * 热门位商品位新增
     * @description 热门位商品位新增，热门位排序号：0-无排序
     * @function addHotCommodity
     * @tpye&return int
     * @param hotCommodityInfo (goodsCode, hotSortNo)
     * @author Conlin
     * @date
     */
    @PostMapping("addHotCommodity")
    public AppResponse addHotCommodity(HotCommodityInfo hotCommodityInfo){

        try {
            return hotCommodityService.addHotCommodity(hotCommodityInfo);
        }catch (Exception e){
            logger.error("新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * 热门位商品位新增 -- 商品选择(分页查询)
     * @description 热门位商品位新增 -- 商品选择(分页查询)
     * @function choosingGoods
     * @tpye&return AppResponse
     * @param goodsInfo
     * @author Conlin
     * @date
     */
    @PostMapping("goodsChoosing")
    public AppResponse choosingGoods(GoodsChoosingVO goodsInfo){

        try {
            return hotCommodityService.goodsChoosing(goodsInfo);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * 热门位商品位删除
     * @description 热门位商品位删除
     * @function removeHotCommodity
     * @tpye&return AppResponse
     * @param | hotCommodityId
     * @author Conlin
     * @date
     */
    @PostMapping("removeHotCommodity")
    public AppResponse removeHotCommodity(String hotCommodityID){

        try {
            return hotCommodityService.removeHotCommodity(hotCommodityID);
        }catch (Exception e){
            logger.error("删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * 热门位商品位修改
     * @description 热门位商品位修改
     * @function updateHotCommodity
     * @tpye&return AppResponse
     * @param hotCommodityInfo (hotCommodityID, goodsCode, hotSortNo, version)
     * @author Conlin
     * @date
     */
    @PostMapping("updateHotCommodity")
    public AppResponse updateHotCommodity(HotCommodityInfo hotCommodityInfo){

        try {
            return hotCommodityService.updateHotCommodity(hotCommodityInfo);
        }catch (Exception e){
            logger.error("修改失败，请刷新！（或该数据已被删除）", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * 热门位商品（列表）查询 + 展示数量修改
     * @description 热门位商品（列表）查询（分页查询） + 展示数量修改
     * @function hotCommodityWithList
     * @tpye&return AppResponse
     * @param hotCommodityInfo (goodsName, goodsCode, pageSize)
     * @author Conlin
     * @date
     */
    @PostMapping("hotCommodityWithList")
    public AppResponse hotCommodityWithList(HotCommodityListVO hotCommodityInfo){
        try {
            return hotCommodityService.hotCommodityWithList(hotCommodityInfo);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
