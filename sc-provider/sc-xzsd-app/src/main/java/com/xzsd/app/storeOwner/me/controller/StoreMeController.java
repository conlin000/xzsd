package com.xzsd.app.storeOwner.me.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.storeOwner.me.entity.StoreOwnerVO;
import com.xzsd.app.storeOwner.me.entity.UpdatePwdVO;
import com.xzsd.app.storeOwner.me.service.StoreMeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/storeOwner/me")
public class StoreMeController {

    @Resource
    private StoreMeService storeMeService;


    /**
     * App店长端店长信息查询
     * @description App店长信息查询
     * @function queryOwner
     * @param
     * @type&return int
     * @author Conlin
     * @date
     */
    @PostMapping("queryOwner")
    public AppResponse queryOwner(){
        try {
            return storeMeService.queryOwner();
        }catch(Exception e) {
            System.out.println("查询失败");
            throw e;
        }
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
    @PostMapping("updatePassword")
    public AppResponse updatePassWord(UpdatePwdVO updatePwdVO){
        try {
            return storeMeService.updatePassword(updatePwdVO);
        }catch(Exception e){
            System.out.println("修改失败");
            throw e;
        }
    }


}
