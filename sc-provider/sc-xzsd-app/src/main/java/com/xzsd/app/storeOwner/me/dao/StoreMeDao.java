package com.xzsd.app.storeOwner.me.dao;
import com.xzsd.app.storeOwner.me.entity.StoreOwnerVO;
import com.xzsd.app.storeOwner.me.entity.UpdatePwdVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StoreMeDao {

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
     * App店长端店长信息查询
     * @description App店长信息查询
     * @function queryOwner
     * @param userCode
     * @type&return int
     * @author Conlin
     * @date
     */
    StoreOwnerVO queryOwner(String userCode);

}
