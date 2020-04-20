package com.xzsd.app.driver.me.dao;
import com.xzsd.app.driver.me.entity.AppDriverInfo;
import com.xzsd.app.driver.me.entity.AppDriverStoreVO;
import com.xzsd.app.driver.me.entity.UpdatePwdVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DriverMeDao {

    /**
     * App司机端司机个人查询
     * @description App司机端司机个人查询
     * @function queryDriver
     * @param userCode
     * @type&return int
     * @author Conlin
     * @date
     */
    AppDriverInfo queryDriver(String userCode);

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
     * app-司机端负责门店查询
     * @description app-司机端负责门店查询
     * @function queryStore
     * @param driverStoreVO
     * @type&return int
     * @author Conlin
     * @date
     */
    AppDriverStoreVO queryStore(AppDriverStoreVO driverStoreVO);


//    /**
//     * app-司机端负责门店查询 ==> 门店地址查询
//     * @description app-司机端负责门店查询
//     * @function getStoreAddress
//     * @param storeCode
//     * @type&return int
//     * @author Conlin
//     * @date
//     */
//    String getStoreAddress(String storeCode);
}
