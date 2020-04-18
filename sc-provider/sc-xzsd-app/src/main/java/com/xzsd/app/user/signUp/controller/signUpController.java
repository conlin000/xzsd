package com.xzsd.app.user.signUp.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.user.signUp.entity.AppSignUpVO;
import com.xzsd.app.user.signUp.service.SignUpService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/signUp")
public class signUpController {

    @Resource
    private SignUpService signUpService;


    /**
     * app-用户端注册
     * @description app-用户端注册
     * @function signUp
     * @param signUpVO (参考接口文档)
     * @type&return int
     * @author Conlin
     * @date
     */
    @PostMapping("signUp")
    public AppResponse signUp(AppSignUpVO signUpVO){
        try {
            return signUpService.signUp(signUpVO);
        }catch (Exception e){
            System.out.println("============注册失败===========");
            throw e;
        }
    }
}
