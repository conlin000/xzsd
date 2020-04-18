package com.xzsd.pc.user.dao;



import com.xzsd.pc.user.entity.QueryUserVO;
import com.xzsd.pc.user.entity.UserInfo;
import com.xzsd.pc.user.entity.UserWithListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserDao {

    /**
     * 计算用户数量
     * @description 用来检测用户是否存在，如果不存在返回值应该是0。
     * @function countUserAccount
     * @param userInfo
     * @type&return int
     * @author Conlin
     * @date
     */
    int countUserAccount(UserInfo userInfo);


    /**
     * 新增用户
     * @function addUser
     * @param userInfo(userAccount, password, userName, sex, email, phone, idCard, userRole)
     * @type&return int
     * @author Conlin
     * @date
     */
    int addUser(UserInfo userInfo);


    /**
     * 用户（列表）查询
     * @function usersWithList
     * @param userInfo
     * @type&return List<UserWithListVO>
     * @author conlin
     * @date
     */
    List<UserWithListVO> usersWithList(UserWithListVO userInfo);


    /**
     * 用户详情查询
     * @function queryUser
     * @param userId
     * @type&return UserInfo
     * @author Conlin
     * @date
     */
    QueryUserVO queryUser(@Param("userId") String userId);


    /**
     * 删除用户信息
     * @function removeUser
     * @param listCode, userId
     * @type&return int
     * @author Conlin
     * @date
     */
    int removeUser(@Param("listCode") List<String> listCode, @Param("userId") String userId);


    /**
     * 修改用户信息
     * @function updateUser
     * @param userInfo
     * @type&return int
     * @author Conlin
     * @date
     */
    int updateUser(UserInfo userInfo);
}

