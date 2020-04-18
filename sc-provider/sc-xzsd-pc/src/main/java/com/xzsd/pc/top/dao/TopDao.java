package com.xzsd.pc.top.dao;

import com.xzsd.pc.top.entity.TopInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TopDao {

    /**
     * 顶部栏信息查询
     * @description 查询顶部栏的用户信息（头像、名称）
     * @function getTop
     * @param currentUserCode 当前用户编码
     * @type&return TopInfo
     * @author Conlin
     * @date
     */
    TopInfo getTop(String currentUserCode);
}
