package com.xzsd.app.driver.me.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.driver.me.entity.UpdatePwdVO;
import com.xzsd.app.driver.me.service.DriverMeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/driver/me")
public class DriverMeController {


    @Resource
    private DriverMeService driverMeService;


    /**
     * App司机端司机个人查询
     * @description App司机端司机个人查询
     * @function queryDriver
     * @param
     * @type&return int
     * @author Conlin
     * @date
     */
    @PostMapping("queryDriver")
    public AppResponse queryDriver(){
        try {
            return driverMeService.queryDriver();
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
    public AppResponse updatePassword(UpdatePwdVO updatePwdVO){
        try {
            return driverMeService.updatePassword(updatePwdVO);
        }catch(Exception e) {
            System.out.println("失败");
            throw e;
        }
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
    @PostMapping("queryStore")
    public AppResponse queryStore(){
        try {
            return driverMeService.queryStore();
        }catch(Exception e) {
            System.out.println("失败");
            throw e;
        }
    }
}
