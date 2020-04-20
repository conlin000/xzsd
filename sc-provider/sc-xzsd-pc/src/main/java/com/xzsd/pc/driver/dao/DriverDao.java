package com.xzsd.pc.driver.dao;

import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverWithListVO;
import com.xzsd.pc.driver.entity.PlaceVO;
import com.xzsd.pc.driver.entity.QueryDriverVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface DriverDao {

    /**
     * 新增：用户账号查重
     * @description 查询用户是否存在，若存在应该返回“1”
     * @function checkUserAccount
     * @param userAccount
     * @type&return int
     * @author Conlin
     * @date
     */
    int checkUserAccount(String userAccount);


    /**
     * 新增 -- 省市区地级选择列表查询
     * @description 新增 -- 省市区地级选择列表查询。地级等级：1-省  2-市  3-区
     * @function placeChoosing
     * @param placeVO
     * @type&return List<PlaceVO>
     * @author Conlin
     * @date
     */
    List<PlaceVO> placeChoosing(PlaceVO placeVO);


    /**
     * 新增--查询店铺邀请码
     * @description 查询店铺邀请码
     * @function getInviteCode
     * @param userCode
     * @type&return int
     * @author Conlin
     * @date
     */
    String getInviteCode(String userCode);



    /**
     * 司机新增（user表）
     * @description 司机新增，新增进user表
     * @function addDriverToUserTable
     * @param driverInfo
     * @type&return int
     * @author Conlin
     * @date
     */
    int addDriverToUserTable(DriverInfo driverInfo);

    /**
     * 司机新增(driver表)
     * @description 司机新增，新增进司机表
     * @function addDriver
     * @param driverInfo
     * @type&return int
     * @author Conlin
     * @date
     */
    int addDriver(DriverInfo driverInfo);



    /**
     * 司机删除
     * @description 司机删除
     * @function removeDriver
     * @param driverCode, userId
     * @type&return int
     * @author Conlin
     * @date
     */
    int removeDriver(@Param("driverCode") String driverCode, @Param("userId") String userId);


    /**
     * 司机信息修改
     * @description 司机信息修改
     * @function updateDriver
     * @param driverInfo
     * @type&return int
     * @author Conlin
     * @date
     */
    int updateDriver(DriverInfo driverInfo);


    /**
     * 司机信息详情查询
     * @description 司机信息详情查询
     * @function queryDriver
     * @param driverCode
     * @type&return int
     * @author Conlin
     * @date
     */
    List<QueryDriverVO> queryDriver(String driverCode);



    /**
     * 司机(列表)查询
     * @description 司机(列表)查询（分页查询）
     * @function driverWithList
     * @param driverWithListVO
     * @type&return List<DriverWithListVO>
     * @author Conlin
     * @date
     */
    List<DriverWithListVO> driverWithList(DriverWithListVO driverWithListVO);
}
