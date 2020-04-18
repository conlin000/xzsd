package com.xzsd.pc.store.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.store.dao.StoreDao;
import com.xzsd.pc.store.entity.PlaceVO;
import com.xzsd.pc.store.entity.QueryStoreVO;
import com.xzsd.pc.store.entity.StoreInfo;
import com.xzsd.pc.store.entity.StoreWithListVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class StoreService {


    @Resource
    private StoreDao storeDao;


    /**
     * 新增 -- 地级选择列表查询
     * @description 新增 -- 地级选择。地级等级：1-省  2-市  3-区
     * @function placeChoosing
     * @param placeVO
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse placeChoosing(PlaceVO placeVO){
        // 新增 -- 地级选择列表查询
        List<PlaceVO> placeVOList = storeDao.placeChoosing(placeVO);
        return AppResponse.success("查询成功", placeVOList);
    }



    /**
     * 新增门店
     * @description 新增门店
     * @function addStore
     * @param storeInfo
     * @type&return int
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addStore(StoreInfo storeInfo){
        // 校验店长，如果输入的账号是店长则返回“1”
        int count = storeDao.checkStoreMan(storeInfo.getUserCode());
        if (count != 1){
            return AppResponse.notFound("此账号不是店长！");
        }
        // 对输入的店长编号进行查询，一个店长只能有一家门店
        count = storeDao.checkUserCode(storeInfo.getUserCode());
        if (count != 0){
            return AppResponse.duplicatError("此账号已有门店！");
        }
        // 检查营业编码是否重复，若重复应返回“0”
        count = storeDao.checkLicenseCode(storeInfo.getLicenseCode());
        if (count != 0){
            return AppResponse.duplicatError("营业执照重复");
        }
        // 找地名
        String address = storeDao.getStoreAddress(storeInfo);
        // 配置地名
        storeInfo.setStoreAddress(address);
        // 使用工具类生成门店编号
        String storeCode = StringUtil.asYouLike(4, 4);
        // 配置门店编号
        storeInfo.setStoreCode(storeCode);
        // 使用工具类获取当前用户id，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 配置创建者
        storeInfo.setCreator(userId);
        // 生成门店邀请码
        String inviteCode = StringUtil.getCapitalLettersAndNum(8);
        // 配置门店邀请码
        storeInfo.setInviteCode(inviteCode);
        // 新增门店
        int flagCount = storeDao.addStore(storeInfo);
        if (flagCount == 0){
            return AppResponse.bizError("新增门店失败");
        }
        return AppResponse.success("新增门店成功");
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
    @Transactional(rollbackFor = Exception.class)
    public AppResponse removeStore(String storeCode){
        //
        List<String> stores = Arrays.asList(storeCode.split(","));
        // 使用工具类获取当前用户id，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 删除门店
        int flagCount = storeDao.removeStore(stores, userId);
        if (flagCount == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }



    /**
     * 修改门店信息
     * @description 修改门店信息
     * @function updateStore
     * @param storeInfo
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateStore(StoreInfo storeInfo){
        // 对输入的店长编号进行查询，一个店长只能有一家门店
        int count = storeDao.checkUserCode(storeInfo.getUserCode());
        if (count != 0){
            return AppResponse.duplicatError("此店长已有门店！");
        }
        // 地址拼接
        if (storeInfo.getProvinceCode() != null || storeInfo.getCityCode() != null ||
            storeInfo.getStateCode() != null || storeInfo.getAddressDetails() != null){
            storeInfo.setStoreAddress(storeDao.getStoreAddress(storeInfo));
        }
        // 使用工具类获取当前用户id，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 配置修改者
        storeInfo.setLastModifiedBy(userId);
        // 修改门店信息
        int flagCount = storeDao.updateStore(storeInfo);
        if (flagCount == 0){
            return AppResponse.versionError("修改订单状态失败，请刷新！（或该数据已被删除）");
        }
        return AppResponse.success("修改成功");
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
    public AppResponse queryStore(String storeCode){
        // 门店详情查询
        QueryStoreVO store = storeDao.queryStore(storeCode);
        return AppResponse.success("查询成功", store);
    }



    /**
     * 门店(列表)查询
     * @description 门店(列表)查询（分页查询）
     * @function storeWithList
     * @param storeWithListVO
     * @type&return  AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse storeWithList(StoreWithListVO storeWithListVO){
        // 分页查询
        PageHelper.startPage(storeWithListVO.getPageNum(), storeWithListVO.getPageSize());
        // 门店(列表)查询
        List<StoreWithListVO> storeList = storeDao.storeWithList(storeWithListVO);
        // 包装page对象
        PageInfo<StoreWithListVO> pageInfo = new PageInfo<>(storeList);
        return AppResponse.success("查询成功", pageInfo);
    }
}
