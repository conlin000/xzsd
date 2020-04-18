package com.xzsd.pc.customer.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.customer.entity.CustomerInfo;
import com.xzsd.pc.customer.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/customers")
public class CustomerController {


    @Resource
    private CustomerService customerService;


    // 日志spring boot自带
    private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);


    /**
     * 客户（列表）查询（分页查询）
     * @description 客户（列表）查询，分页查询
     * @function customerWithList
     * @param customerInfo (pageNum, pageSize, userRole, userName, userAccount)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("customersWithList")
    public AppResponse customerWithList(CustomerInfo customerInfo){

        try {
            return customerService.customerWithList(customerInfo);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
