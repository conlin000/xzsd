package com.xzsd.app.storeOwner.driver.dao;
import com.xzsd.app.storeOwner.driver.entity.DriverListVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreDriverDao {

    /**
     * App店长端“司机（列表）查询”
     * @description App店长端“司机（列表）查询”
     * @function driverWithList
     * @param driverListVO ()
     * @type&return List<DriverListVO>
     * @author Conlin
     * @date
     */
    List<DriverListVO> driverWithList(DriverListVO driverListVO);
}
