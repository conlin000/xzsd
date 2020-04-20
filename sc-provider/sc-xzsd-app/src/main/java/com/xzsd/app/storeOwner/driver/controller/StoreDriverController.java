package com.xzsd.app.storeOwner.driver.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.storeOwner.driver.entity.DriverListVO;
import com.xzsd.app.storeOwner.driver.service.StoreDriverService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/storeOwner/driver")
public class StoreDriverController {

    @Resource
    private StoreDriverService storeDriverService;


    /**
     * App店长端“司机（列表）查询”
     * @description App店长端“司机（列表）查询”
     * @function driverWithList
     * @param driverListVO
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("driverWithList")
    public AppResponse driverWithList(DriverListVO driverListVO){
        try {
            return storeDriverService.driverWithList(driverListVO);
        }catch(Exception e) {
            System.out.println("查询失败");
            throw e;
        }
    }
}
