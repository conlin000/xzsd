package com.xzsd.pc.driver.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.driver.dao.DriverDao;
import com.xzsd.pc.driver.entity.DriverInfo;
import com.xzsd.pc.driver.entity.DriverWithListVO;
import com.xzsd.pc.driver.entity.PlaceVO;
import com.xzsd.pc.driver.entity.QueryDriverVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class DriverService {


    @Resource
    private DriverDao driverDao;



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
        // 地级选择列表查询
        List<PlaceVO> placeVOList = driverDao.placeChoosing(placeVO);
        return AppResponse.success("查询成功", placeVOList);
    }



    /**
     * 司机新增
     * @description 司机新增
     * @function addDriver
     * @param driverInfo
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addDriver(DriverInfo driverInfo){
        String userAccount = driverInfo.getUserAccount();
        // 检查账号是否存在，若不存在应返回0
        int count = driverDao.checkUserAccount(userAccount);
        if (count != 0){
            return AppResponse.bizError("此用户已存在！");
        }
        // 使用工具类生成司机id，并配置司机Code
        driverInfo.setDriverCode("SJ" + StringUtil.asYouLike(0, 18));
        // 获取当前用户id，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 配置创建者
        driverInfo.setCreator(userId);
        // 加进user表
        int flagCount = driverDao.addDriverToUserTable(driverInfo);
        if (flagCount == 0){
            return AppResponse.bizError("新增司机失败！");
        }
        // 加进driver表
        flagCount = driverDao.addDriver(driverInfo);
        if (flagCount == 0){
            return AppResponse.bizError("新增司机失败！");
        }
        return AppResponse.success("新增司机成功！");
    }



    /**
     * 司机删除
     * @description 司机删除
     * @function removeDriver
     * @param driverCode,
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse removeDriver(String driverCode){
        // 使用工具类获取当前用户id，用于修改创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 删除司机
        int flagCount = driverDao.removeDriver(driverCode, userId);
        if (flagCount == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.bizError("删除成功");
    }



    /**
     * 司机信息修改
     * @description 司机信息修改
     * @function updateDriver
     * @param driverInfo
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateDriver(DriverInfo driverInfo){
        // 使用工具类获取当前用户id，用于修改创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 配置修改者
        driverInfo.setModifiedBy(userId);
        // 司机信息修改
        int flagCount = driverDao.updateDriver(driverInfo);
        if (flagCount == 0){
            return AppResponse.versionError("修改失败，请刷新！（或该数据已被删除）");
        }
        return AppResponse.success("修改成功");
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
    public AppResponse queryDriver(String driverCode){
        // 司机信息详情查询
        QueryDriverVO queryDriverVO =  driverDao.queryDriver(driverCode);
        return AppResponse.success("查询成功", queryDriverVO);
    }



    /**
     * 司机(列表)查询
     * @description 司机(列表)查询（分页查询）
     * @function driverWithList
     * @param driverWithListVO
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse driverWithList(DriverWithListVO driverWithListVO){
        // 分页查询
        PageHelper.startPage(driverWithListVO.getPageNum(), driverWithListVO.getPageSize());
        // 司机(列表)查询
        List<DriverWithListVO> driverWithListVOs = driverDao.driverWithList(driverWithListVO);
        // 包装page对象
        PageInfo<DriverWithListVO> pageInfo = new PageInfo<>(driverWithListVOs);
        return AppResponse.success("查询成功", pageInfo);
    }
}
