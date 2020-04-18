package com.xzsd.pc.store.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.store.entity.PlaceVO;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreWithListVO;
import com.xzsd.pc.store.service.StoreService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/store")
public class StoreController {

    @Resource
    private StoreService storeService;


    // spring boot  自带日志
    private static final Logger logger = LoggerFactory.getLogger(StoreController.class);


    /**
     * 新增 -- 省市区地级选择列表查询
     * @description 新增 -- 省市区地级选择。地级等级：1-省  2-市  3-区
     * @function placeChoosing
     * @param placeVO (parentPlaceCode, placeLevel)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("placeChoosing")
    public AppResponse placeChoosing(PlaceVO placeVO){
        try {
            return storeService.placeChoosing(placeVO);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * 新增门店
     * @description 新增门店
     * @function addStore
     * @param storeInfo
     * (storeName, phone, userCode, LicenseCode, provinceCode, cityCode, stateCode, addressDetails)
     * @type&return int
     * @author Conlin
     * @date
     */
    @PostMapping("addStore")
    public AppResponse addStore(StoreInfo storeInfo){
        try {
            return storeService.addStore(storeInfo);
        }catch (Exception e){
            logger.error("新增门店失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * 删除门店
     * @description 删除门店
     * @function removeStore
     * @param storeCode
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("removeStore")
    public AppResponse removeStore(String storeCode){
        try {
            return storeService.removeStore(storeCode);
        }catch (Exception e){
            logger.error("删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * 修改门店信息
     * @description 修改门店信息
     * @function updateStore
     * @param storeInfo
     * (storeCode, storeName, userCode, phone, LicenseCode, provinceCode, cityCode, stateCode, addressDetails, version)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("updateStore")
    public AppResponse updateStore(StoreInfo storeInfo){
        try {
            return storeService.updateStore(storeInfo);
        }catch (Exception e){
            logger.error("修改订单状态失败，请刷新！（或该数据已被删除）", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * 门店详情查询
     * @description 门店详情查询
     * @function queryStore
     * @param storeCode
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("queryStore")
    public AppResponse queryStore(String storeCode){
        try {
            return storeService.queryStore(storeCode);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 门店(列表)查询
     * @description 门店(列表)查询（分页查询）
     * @function storeWithList
     * @param storeWithListVO
     * (storeCode, storeName, userName, provinceCode, cityCode, stateCode, pageNum, pageSize)
     * @type&return  AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("storeWithList")
    public AppResponse storeWithList(StoreWithListVO storeWithListVO){
        try {
            return storeService.storeWithList(storeWithListVO);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
