package com.xzsd.app.user.signUp.dao;

import com.xzsd.app.user.signUp.entity.AppSignUpVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SignUpDao {

    /**
     * 计算用户数量
     * @description 用来检测用户是否存在，如果不存在返回值应该是0。
     * @function countUserAccount
     * @param userAccount 用户账号
     * @type&return int
     * @author Conlin
     * @date
     */
    int countUserAccount(String userAccount);

    /**
     * 校验邀请码
     * @description 校验邀请码是否存在，若存在应返回‘1’
     * @function checkInviteCode
     * @param inviteCode
     * @type&return int
     * @author Conlin
     * @date
     */
    int checkInviteCode(String inviteCode);

    /**
     * app-用户端注册
     * @description app-用户端注册
     * @function signUp
     * @param signUpVO
     * @type&return int
     * @author Conlin
     * @date
     */
    int signUp(AppSignUpVO signUpVO);
}
