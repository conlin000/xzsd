package com.xzsd.app.user.me.dao;
import com.xzsd.app.user.me.entity.UpdatePwdVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MeDao {

    /**
     * 原密码查找
     * @description 从数据库查找已经被编码的密码
     * @function getPassword
     * @param userCode
     * @type&return int
     * @author Conlin
     * @date
     */
    String getPassword(String userCode);


    /**
     * 邀请码匹配查找
     * @description 原密码匹配查找,若存在应该返回”1“
     * @function checkInviteCode
     * @param (inviteCode)
     * @type&return int
     * @author Conlin
     * @date
     */
    int checkInviteCode(String inviteCode);


    /**
     * 修改密码
     * @description 修改密码
     * @function updatePassword
     * @param updatePwdVO (password, newPassword, confirmPwd)
     * @type&return int
     * @author Conlin
     * @date
     */
    int updatePassword(UpdatePwdVO updatePwdVO);


    /**
     * 修改店铺邀请码
     * @description 修改店铺邀请码
     * @function updateInviteCode
     * @param updatePwdVO (inviteCode)
     * @type&return int
     * @author Conlin
     * @date
     */
    int updateInviteCode(UpdatePwdVO updatePwdVO);
}
