package com.xzsd.app.driver.me.service;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.driver.me.dao.DriverMeDao;
import com.xzsd.app.driver.me.entity.AppDriverInfo;
import com.xzsd.app.driver.me.entity.AppDriverStoreVO;
import com.xzsd.app.driver.me.entity.UpdatePwdVO;
import com.xzsd.app.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class DriverMeService {

    @Resource
    private DriverMeDao driverMeDao;

    /**
     * App司机端司机个人查询
     * @description App司机端司机个人查询
     * @function queryDriver
     * @param
     * @type&return int
     * @author Conlin
     * @date
     */
    public AppResponse queryDriver(){
        // 获得当前用户
        String userCode = SecurityUtils.getCurrentUserId();
        // 查询
        AppDriverInfo driverInfo = driverMeDao.queryDriver(userCode);
        return AppResponse.success("成功", driverInfo);
    }


    /**
     * 修改密码
     * @description 修改密码
     * @function updatePassWord
     * @param updatePwdVO (password, newPassword, confirmPwd)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updatePassword(UpdatePwdVO updatePwdVO){
        // 获取当前用户
        String userId = SecurityUtils.getCurrentUserId();
        // 配置当前用户
        updatePwdVO.setUserId(userId);
        // 查询原密码
        String encodedPassword = driverMeDao.getPassword(userId);
        // 判断原密码和输入的密码是否匹配
        if (!PasswordUtils.isOk(updatePwdVO.getPassword(), encodedPassword)){
            return AppResponse.notFound("原密码错误");
        }
        // 新密码是否一致
        if (updatePwdVO.getNewPassword().equals(updatePwdVO.getConfirmPwd())){
            // 一致：加密密码
            String pwd = updatePwdVO.getNewPassword();
            // 加密密码
            pwd = PasswordUtils.generatePassword(pwd);
            updatePwdVO.setNewPassword(pwd);
            // 修改密码
            int count = driverMeDao.updatePassword(updatePwdVO);
            if (count == 0){
                return AppResponse.bizError("修改失败");
            }
        }else {
            // 不一致
            return AppResponse.bizError("新密码不一致");
        }
        // 修改成功
        return AppResponse.success("修改成功");
    }


    /**
     * app-司机端负责门店查询
     * @description app-司机端负责门店查询
     * @function queryStore
     * @param
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse queryStore(){
        // 获取当前用户编码
        AppDriverStoreVO driverStoreVO = new AppDriverStoreVO();
        driverStoreVO.setUserCode(SecurityUtils.getCurrentUserId());
        // 司机端负责门店查询
        AppDriverStoreVO driverStoreVOS = driverMeDao.queryStore(driverStoreVO);
        if (driverStoreVOS == null){
            return AppResponse.notFound("查询失败");
        }
        return AppResponse.success("成功", driverStoreVOS);
    }
}
