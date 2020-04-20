package com.xzsd.app.user.goodsDetails.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.user.goodsDetails.service.GoodsDetailsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/goodsDetails")
public class GoodsDetailsController {


    @Resource
    private GoodsDetailsService goodsDetailsService;


    // Spring Boot 自带日志
    private static final Logger logger = LoggerFactory.getLogger(GoodsDetailsController.class);




    /**
     * APP商品详情查询（点击跳转）
     * @description APP商品详情查询（点击跳转）
     * @function GoodsDetailsDao
     * @param goodsCode
     * @type&return GoodsDetailsVO
     * @author Conlin
     * @date
     */
    @PostMapping("goodsDetails")
    public AppResponse goodsDetails(String goodsCode){
        try {
            return goodsDetailsService.goodsDetails(goodsCode);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }

}
