package com.xzsd.app.user.me.service;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.user.me.dao.MeDao;
import com.xzsd.app.user.me.entity.UpdatePwdVO;
import com.xzsd.app.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class MeService {


    @Resource
    private MeDao meDao;


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
    public AppResponse updatePassWord(UpdatePwdVO updatePwdVO){

        // 获取当前用户
        String userId = SecurityUtils.getCurrentUserId();
        // 配置当前用户
        updatePwdVO.setUserId(userId);
        // 查询原密码
        String encodedPassword = meDao.getPassword(userId);
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
            int count = meDao.updatePassword(updatePwdVO);
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
     * 修改店铺邀请码
     * @description 修改店铺邀请码
     * @function updateInviteCode
     * @param updatePwdVO (inviteCode)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateInviteCode(UpdatePwdVO updatePwdVO){
        // 获取当前用户
        updatePwdVO.setUserId(SecurityUtils.getCurrentUserId());
        // 检查输入的邀请码是否存在
        int count = meDao.checkInviteCode(updatePwdVO.getInviteCode());
        if (count != 1){
            return AppResponse.bizError("您输入的门店不存在");
        }
        // 修改店铺邀请码
        count = meDao.updateInviteCode(updatePwdVO);
        if (count == 0){
            return AppResponse.bizError("失败");
        }
        return AppResponse.success("修改成功");
    }
}
