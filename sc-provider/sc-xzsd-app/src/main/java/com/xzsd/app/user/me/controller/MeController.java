package com.xzsd.app.user.me.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.user.me.entity.UpdatePwdVO;
import com.xzsd.app.user.me.service.MeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/me")
public class MeController {

    @Resource
    private MeService meService;


    /**
     * 修改密码
     * @description 修改密码
     * @function updatePassWord
     * @param updatePwdVO (password, newPassword, confirmPwd)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("updatePassword")
    public AppResponse updatePassWord(UpdatePwdVO updatePwdVO){
        try {
            return meService.updatePassWord(updatePwdVO);
        }catch(Exception e){
            System.out.println("修改失败");
            throw e;
        }
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
    @PostMapping("updateInviteCode")
    public AppResponse updateInviteCode(UpdatePwdVO updatePwdVO){
        try {
            return meService.updateInviteCode(updatePwdVO);
        }catch(Exception e){
            System.out.println("修改失败");
            throw e;
        }
    }
}
