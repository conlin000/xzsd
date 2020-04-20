package com.xzsd.pc.user.controller;



import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserWithListVO;
import com.xzsd.pc.user.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 *  注意！函数不能有static！
 *
 */


@RestController
@RequestMapping("/user")
//@Validated
public class UserController {

    // 日志spring boot自带
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;



    /**
     * 新增用户
     * @function addUser
     * @param userInfo(userAccount, password, userName, sex, email, phone, idCard, userRole)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("addUser")
    //@RequestMapping(value = "addUser")
    public AppResponse addUser(UserInfo userInfo){

        try {

            AppResponse appResponse = userService.addUser(userInfo);
            return appResponse;
        }catch (Exception e){
            logger.error("用户新增失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 用户（列表）查询
     * @function usersWithList
     * @param userInfo(userAccount, userName, userRole, pageNum, pageSize)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping(value = "usersWithList")
    public AppResponse usersWithList(UserWithListVO userInfo){

        try{
            return userService.usersWithList(userInfo);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 用户详情查询
     * @function queryUser
     * @param userId
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping(value = "queryUser")
    public AppResponse queryUser(String userId){

        try{
            return userService.queryUser(userId);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 删除用户
     * @function removeUser
     * @param userId
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("removeUser")
    public AppResponse removeUser(String userId){

        try {
            // 获取用户id
            String userCode = SecurityUtils.getCurrentUserId();
            return userService.removeUser(userId, userCode);
        }catch (Exception e) {
            logger.error("用户删除错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 修改用户
     * @function updateUser
     * @param userInfo(userId, password, userName, sex, email, phone, idCard, version)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("updateUser")
    public AppResponse updateUser(UserInfo userInfo){
        try {
            return userService.updateUser(userInfo);
        }catch (Exception e) {
            logger.error("修改用户信息错误", e);
            System.out.println(e.toString());
            throw e;
        }
    }





}
