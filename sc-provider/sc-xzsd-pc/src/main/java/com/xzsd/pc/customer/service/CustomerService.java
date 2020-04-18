package com.xzsd.pc.customer.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.customer.dao.CustomerDao;
import com.xzsd.pc.customer.entity.CustomerInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class CustomerService {


    @Resource
    private CustomerDao customerDao;


    /**
     * 客户（列表）查询（分页查询）
     * @description 客户（列表）查询，分页查询
     * @function customerWithList
     * @param customerInfo
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse customerWithList(CustomerInfo customerInfo){
        // 获取当前用户编码
        customerInfo.setCurrentUserCode(SecurityUtils.getCurrentUserId());
        // 分页查询
        PageHelper.startPage(customerInfo.getPageNum(), customerInfo.getPageSize());
        // 客户（列表）查询
        List<CustomerInfo> customerInfoList = customerDao.customerWithList(customerInfo);
        // 包装Page对象
        PageInfo<CustomerInfo> pageInfo = new PageInfo<>(customerInfoList);
        return AppResponse.success("查询成功", pageInfo);
    }
}
