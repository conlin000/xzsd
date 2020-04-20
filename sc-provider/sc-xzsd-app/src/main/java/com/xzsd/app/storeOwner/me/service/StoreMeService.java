package com.xzsd.app.storeOwner.me.service;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.storeOwner.me.dao.StoreMeDao;
import com.xzsd.app.storeOwner.me.entity.StoreOwnerVO;
import com.xzsd.app.storeOwner.me.entity.UpdatePwdVO;
import com.xzsd.app.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class StoreMeService {


    @Resource
    private StoreMeDao storeMeDao;


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
        String encodedPassword = storeMeDao.getPassword(userId);
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
            int count = storeMeDao.updatePassword(updatePwdVO);
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
     * App店长端店长信息查询
     * @description App店长信息查询
     * @function queryOwner
     * @param
     * @type&return int
     * @author Conlin
     * @date
     */
    public AppResponse queryOwner(){
        // 获得店长编码用于查询门店编码
        String userCode = SecurityUtils.getCurrentUserId();
        // 获取信息
        StoreOwnerVO storeOwnerVO = storeMeDao.queryOwner(userCode);
        return AppResponse.success("成功", storeOwnerVO);
    }
}
