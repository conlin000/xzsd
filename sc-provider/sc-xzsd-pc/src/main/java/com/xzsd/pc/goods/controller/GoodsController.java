package com.xzsd.pc.goods.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.goods.entity.ClassChooseVO;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.GoodsWithListVO;
import com.xzsd.pc.goods.service.GoodsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/goods")
public class GoodsController {


    // 日志spring boot自带
    private static final Logger logger = LoggerFactory.getLogger(GoodsController.class);

    @Resource
    private GoodsService goodsService;



    /**
     * 商品新增
     * @description 新增商品
     * @function addGoods
     * @tpye&return AppResponse
     * @param goodsInfo
     * @author Conlin
     * @date
     */
    @PostMapping("addGoods")
    public AppResponse addGoods(GoodsInfo goodsInfo){

        try {

            // 新增商品
            AppResponse appResponse = goodsService.addGoods(goodsInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("新增商品失败！", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     *商品删除
     * @description 删除商品
     * @function removeGoods
     * @tpye&return AppResponse
     * @param goodsCode
     * @author Conlin
     * @date
     */
    @PostMapping("removeGoods")
    public AppResponse removeGoods(String goodsCode){

        try{
            /*
             * 获取用户id
             * 用于记录修改创建者、创建时间、修改者等
             */
            String userId = SecurityUtils.getCurrentUserId();

            return goodsService.removeGoods(goodsCode, userId);
        }catch (Exception e){
            logger.error("商品删除失败", e);
            System.out.println(e.toString());
            throw e;
        }

    }


    /**
     * 商品（列表）查询
     * @description 商品查询，使用到分页查询
     * @function goodsWithList
     * @tpye&return AppResponse
     * @param goodsInfo(goodName, goodState, advertisement, press, author, pageNum, pageSize)
     * @author Conlin
     * @date
     */
    @PostMapping("goodsWithList")
    public AppResponse goodsWithList(GoodsWithListVO goodsInfo){

        try {
            return goodsService.goodsWithList(goodsInfo);
        }catch (Exception e){
            logger.error("查询失败");
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 商品详情查询
     * @description 商品详情查询
     * @function queryGoods(goodsCode)
     * @tpye&return AppResponse
     * @param goodsCode
     * @author Conlin
     * @date
     */
    @PostMapping("queryGoods")
    public AppResponse queryGoods(String goodsCode){

        try {

            return goodsService.queryGoods(goodsCode);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 商品信息修改
     * @description 商品详情查询
     * @function updateGoods
     * @tpye&return AppResponse
     * @param goodsInfo
     * @author Conlin
     * @date
     */
    @PostMapping("updateGoods")
    public AppResponse updateGoods(GoodsInfo goodsInfo){

        try {
            // 获取当前用户，记录修改者或创建者
            String userId = SecurityUtils.getCurrentUserId();
            goodsInfo.setModifiedBy(userId);

            //修改商品信息
            return goodsService.updateGoods(goodsInfo);
        }catch (Exception e){
            logger.error("修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 修改商品状态
     * @description 商品状态：0-在售  1-已下架  2-未发布
     * @function changeGoodsState
     * @tpye&return int
     * @param goodsInfo (goodsCodes, goodsState, version)
     * @author Conlin
     * @date
     */
    @PostMapping("changeGoodsState")
    public AppResponse changeGoodsState(GoodsInfo goodsInfo){

        try {

            // 修改商品状态
            return goodsService.changeGoodsState(goodsInfo);
        }catch (Exception e){
            logger.error("修改失败", e);
            System.out.println(e.toString());
            throw e;
        }

    }


    /**
     * 一级分类下拉查询
     * @description 新增商品时的一级分类查询接口
     * @function firClassChoosing
     * @tpye&return AppResponse
     * @param classChooseVO
     * @author Conlin
     * @date
     */
    @PostMapping("firClassChoosing")
    public AppResponse firClassChoosing(ClassChooseVO classChooseVO){
        try {
            return goodsService.firClassChoosing(classChooseVO);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 二级分类下拉查询
     * @description 新增商品时的二级分类查询接口
     * @function secClassChoosing
     * @tpye&return AppResponse
     * @param parentClassCode
     * @author Conlin
     * @date
     */
    @PostMapping("secClassChoosing")
    public AppResponse secClassChoosing(String parentClassCode){
        try {
            return goodsService.secClassChoosing(parentClassCode);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
