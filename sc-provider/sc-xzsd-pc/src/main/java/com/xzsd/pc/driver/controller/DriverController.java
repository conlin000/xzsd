package com.xzsd.pc.driver.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverWithListVO;
import com.xzsd.pc.driver.entity.PlaceVO;
import com.xzsd.pc.driver.service.DriverService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/driver")
public class DriverController {


    @Resource
    private DriverService driverService;


    // 日志spring boot自带
    private static final Logger logger = LoggerFactory.getLogger(DriverController.class);




    /**
     * 新增 -- 省市区地级选择列表查询
     * @description 新增 -- 省市区地级选择。地级等级：1-省  2-市  3-区
     * @function placeChoosing
     * @param placeVO (parentCode, placeLevel)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("placeChoosing")
    public AppResponse placeChoosing(PlaceVO placeVO){
        try {
            return driverService.placeChoosing(placeVO);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }




    /**
     * 司机新增
     * @description 司机新增
     * @function addDriver
     * @param driverInfo
     * （userName, userAccount, password, phone, idCard, provinceCode, cityCode, stateCode）
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("addDriver")
    public AppResponse addDriver(DriverInfo driverInfo){
        try {
            return driverService.addDriver(driverInfo);
        }catch (Exception e){
            logger.error("司机新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * 司机删除
     * @description 司机删除
     * @function removeDriver
     * @param driverCode
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("removeDriver")
    public AppResponse removeDriver(String driverCode){

        try {
            return driverService.removeDriver(driverCode);
        }catch (Exception e){
            logger.error("删除失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }




    /**
     * 司机信息修改
     * @description 司机信息修改
     * @function updateDriver
     * @param driverInfo (driverCode, userName, password, phone, provinceCode, cityCode, stateCode, version )
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("updateDriver")
    public AppResponse updateDriver(DriverInfo driverInfo){
        try {
            return driverService.updateDriver(driverInfo);
        }catch (Exception e){
            logger.error("修改失败，请刷新！（或该数据已被删除）", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * 司机信息详情查询
     * @description 司机信息详情查询
     * @function queryDriver
     * @param driverCode
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("queryDriver")
    public AppResponse queryDriver(String driverCode){
        try {
            return driverService.queryDriver(driverCode);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * 司机(列表)查询
     * @description 司机(列表)查询（分页查询）
     * @function driverWithList
     * @param driverWithListVO (driverCode, userName, provinceCode, cityCode, stateCode, pageNum, pageSize)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("driverWithList")
    public AppResponse driverWithList(DriverWithListVO driverWithListVO){
        try{
            return driverService.driverWithList(driverWithListVO);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
