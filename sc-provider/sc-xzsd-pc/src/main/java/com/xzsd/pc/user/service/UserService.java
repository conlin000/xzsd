package com.xzsd.pc.user.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.user.dao.UserDao;
import com.xzsd.pc.user.entity.QueryUserVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserWithListVO;
import com.xzsd.pc.utils.PasswordUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {


    @Resource
    private UserDao userDao;


    /**
     * 新增用户
     * @description 新增用户。
     * @function adduser
     * @param userInfo(userAccount, password, userName, sex, email, phone, idCard, userRole)
     * @type AppResponse
     * @author conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addUser(UserInfo userInfo){

        // 检查角色是否合法
        if(userInfo.getUserRole() >= 4 || userInfo.getUserRole() < 0){
            return AppResponse.paramError("角色错误，请重新输入!");
        }
        // 检查性别是否合法
        if (userInfo.getSex() < 0 || userInfo.getSex() >= 2){
            return AppResponse.paramError("性别错误，请重新输入!（0-女，1-男）");
        }
        // 检查用户是否已存在
        int userCount = userDao.countUserAccount(userInfo);
        if (userCount != 0){
            return AppResponse.duplicatError("用户已存在，请重新输入!");
        }
        // 密码加密
        String pwd = PasswordUtils.generatePassword(userInfo.getPassword());
        // 配置加密后的密码
        userInfo.setPassword(pwd);
        // 使用工具类生成用户id
        userInfo.setUserId(StringUtil.getCommonCode(2));
        userInfo.setIsDelete(0);
        // 获取当前用户id，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        userInfo.setCreator(userId);
        // 新增用户
        int count = userDao.addUser(userInfo);
        if (count == 0){
            return AppResponse.bizError("新增用户失败！");
        }
        return AppResponse.success("新增用户成功！");
    }


    /**
     * 用户（列表)查询
     * @description 有分页查询
     * @function usersWithList
     * @param userInfo
     * @type AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse usersWithList(UserWithListVO userInfo){
        // 分页查询
        PageHelper.startPage(userInfo.getPageNum(), userInfo.getPageSize());
        List<UserWithListVO> userInfoList = userDao.usersWithList(userInfo);
        // 包装Page对象
        PageInfo<UserWithListVO> pageData = new PageInfo<>(userInfoList);
        return AppResponse.success("查询成功", pageData);
    }


    /**
     * 用户详情查询
     * @function queryUser
     * @param userId
     * @type AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse queryUser(String userId){
        // 用户详情查询
        QueryUserVO userInfo = userDao.queryUser(userId);
        return AppResponse.success("查询成功", userInfo);

    }


    /**
     * 删除用户信息
     * @function removeUser
     * @param userCode, userId
     * @type int
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse removeUser(String userCode, String userId){

        List<String> listCode = Arrays.asList(userCode.split(","));
        // 删除用户
        int count = userDao.removeUser(listCode, userId);
        if (count == 0){
            return AppResponse.bizError("删除失败，请重试！");
        }
        return AppResponse.success("删除成功！");
    }


    /**
     * 修改用户信息
     * @function updateUser
     * @param userInfo
     * @type int
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateUser(UserInfo userInfo){
        // 获取当前用户id，记录修改者或创建者
        String userId = SecurityUtils.getCurrentUserId();
        userInfo.setModifiedBy(userId);
        // 密码加密
        if (userInfo.getPassword() != null && userInfo.getPassword() != ""){
            // 密码加密
            String pwd = PasswordUtils.generatePassword(userInfo.getPassword());
            // 配置加密后的密码
            userInfo.setPassword(pwd);
        }
        // 修改用户信息
        int count = userDao.updateUser(userInfo);
        if (0 == count) {
            return AppResponse.versionError("数据有变化，请刷新！(或数据已被删除)");
        }
        return AppResponse.success("修改成功");
    }
}
