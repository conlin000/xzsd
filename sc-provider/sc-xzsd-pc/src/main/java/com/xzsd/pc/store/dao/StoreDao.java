package com.xzsd.pc.store.dao;

import com.xzsd.pc.store.entity.PlaceVO;
import com.xzsd.pc.store.entity.QueryStoreVO;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreWithListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface StoreDao {


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
     * 新增门店 ==> 校验店长身份
     * @description 校验店长，如果输入的账号是店长则返回“1”
     * @function checkStoreMan
     * @param userCode
     * @type&return int
     * @author Conlin
     * @date
     */
    int checkStoreMan(String userCode);


    /**
     * 新增门店 ==> 店长查重
     * @description 对输入的店长编号查询，一个店长只能有一家门店，若不存在应该返回“0”
     * @function checkUserCode
     * @param userCode
     * @type&return int
     * @author Conlin
     * @date
     */
    int checkUserCode(String userCode);

    /**
     * 新增门店 ==> 营业编码查重
     * @description 检查营业编码是否重复，若重复应返回“0”
     * @function checkLicenseCode
     * @param licenseCode
     * @type&return int
     * @author Conlin
     * @date
     */
    int checkLicenseCode(String licenseCode);

    /**
     * 找地名
     * @description 找地名
     * @function getStoreAddress
     * @param object
     * @type&return int
     * @author Conlin
     * @date
     */
    String getStoreAddress(Object object);

    /**
     * 新增门店
     * @description 新增门店
     * @function addStore
     * @param storeInfo
     * @type&return int
     * @author Conlin
     * @date
     */
    int addStore(StoreInfo storeInfo);



    /**
     * 删除门店
     * @description 删除门店
     * @function removeStore
     * @param storeCode, userId
     * @type&return int
     * @author Conlin
     * @date
     */
    int removeStore(@Param("storeCode") List<String> storeCode, @Param("userId") String userId);



    /**
     * 修改门店信息
     * @description 修改门店信息
     * @function updateStore
     * @param storeInfo
     * @type&return int
     * @author Conlin
     * @date
     */
    int updateStore(StoreInfo storeInfo);



    /**
     * 门店详情查询
     * @description 门店详情查询
     * @function queryStore
     * @param storeCode
     * @type&return QueryStoreVO
     * @author Conlin
     * @date
     */
    QueryStoreVO queryStore(String storeCode);



    /**
     * 门店(列表)查询
     * @description 门店(列表)查询（分页查询）
     * @function storeWithList
     * @param storeWithListVO
     * @type&return  List<StoreWithListVO>
     * @author Conlin
     * @date
     */
    List<StoreWithListVO> storeWithList(StoreWithListVO storeWithListVO);
}
