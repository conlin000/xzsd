package com.xzsd.pc.top.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.top.dao.TopDao;
import com.xzsd.pc.top.entity.TopInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TopService {

    @Resource
    private TopDao topDao;

    /**
     * 顶部栏信息查询
     * @description 查询顶部栏的用户信息（头像、名称）
     * @function getTop
     * @param
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse getTop(){
        // 获取当前用户
        String userCode = SecurityUtils.getCurrentUserId();
        // 顶部栏信息查询
        TopInfo topInfo = topDao.getTop(userCode);
        // 判断顶部栏信息是否合法
        if (topInfo == null){
            return AppResponse.notFound("查询失败");
        }
        return AppResponse.success("查询成功", topInfo);
    }
}
