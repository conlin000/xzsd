package com.xzsd.app.user.signUp.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.user.signUp.dao.SignUpDao;
import com.xzsd.app.user.signUp.entity.AppSignUpVO;
import com.xzsd.app.utils.PasswordUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SignUpService {

    @Resource
    private SignUpDao signUpDao;

    /**
     * app-用户端注册
     * @description app-用户端注册
     * @function signUp
     * @param signUpVO (参考接口文档)
     * @type&return int
     * @author Conlin
     * @date
     */
    public AppResponse signUp(AppSignUpVO signUpVO){
        // 判断输入的账号是否已存在，若合法应该返回“0”
        int count = signUpDao.countUserAccount(signUpVO.getUserAccount());
        if (count != 0) {
            return AppResponse.duplicatError("此账号已存在");
        }
        // 如果两次输入代码不一致，返回错误
        if (signUpVO.getPassword().equals(signUpVO.getPasswordAgain()) == false){
            return AppResponse.unknownError("两次密码不一致！");
        }
        // 当邀请码不为空和不为空字符串时，校验邀请码
        if (signUpVO.getInvite() != null && signUpVO.getInvite() != ""){
            // 校验邀请码
            count = signUpDao.checkInviteCode(signUpVO.getInvite());
            if (count != 1) {
                return AppResponse.notFound("邀请码不存在");
            }
        }
        // 密码加密
        String pwd = signUpVO.getPassword();
        signUpVO.setPassword(PasswordUtils.generatePassword(pwd));
        // 获得当前用户id，并配置记录创建者
        signUpVO.setCreator(SecurityUtils.getCurrentUserId());
        // 生成用户编码，并配置
        signUpVO.setUserCode(StringUtil.getCommonCode(2));
        // 用户注册
        int flag = signUpDao.signUp(signUpVO);
        if (flag == 0){
            return AppResponse.bizError("注册失败");
        }
        return AppResponse.success("注册成功");
    }

}
