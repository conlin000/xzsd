package com.xzsd.pc.top.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.top.service.TopService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/top")
public class TopController {

    @Resource
    private TopService topService;

    // 日志spring boot自带
    private static final Logger logger = LoggerFactory.getLogger(TopController.class);


    /**
     * 顶部栏信息查询
     * @description 查询顶部栏的用户信息（头像、名称）
     * @function getTop
     * @param
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("getTop")
    public AppResponse getTop(){
        //
        try {
            return topService.getTop();
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
