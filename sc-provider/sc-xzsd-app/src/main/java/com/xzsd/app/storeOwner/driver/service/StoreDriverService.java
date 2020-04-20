package com.xzsd.app.storeOwner.driver.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.storeOwner.driver.dao.StoreDriverDao;
import com.xzsd.app.storeOwner.driver.entity.DriverListVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoreDriverService {

    @Resource
    private StoreDriverDao storeDriverDao;

    /**
     * App店长端“司机（列表）查询”
     * @description App店长端“司机（列表）查询”
     * @function driverWithList
     * @param driverListVO
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse driverWithList(DriverListVO driverListVO){
        // 获取当前店长，用于查询和店长同区域的司机
        driverListVO.setCurrentUserCode(SecurityUtils.getCurrentUserId());
        // App店长端“司机（列表）查询”
        List<DriverListVO> driverListVOList = storeDriverDao.driverWithList(driverListVO);
        return AppResponse.success("成功", driverListVOList);
    }
}
