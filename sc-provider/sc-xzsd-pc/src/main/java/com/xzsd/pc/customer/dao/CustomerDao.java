package com.xzsd.pc.customer.dao;

import com.xzsd.pc.customer.entity.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface CustomerDao {


    /**
     * 客户（列表）查询（分页查询）
     * @description 客户（列表）查询，分页查询
     * @function customerWithList
     * @param customerInfo
     * @type&return List<CustomerInfo>
     * @author Conlin
     * @date
     */
    List<CustomerInfo> customerWithList(CustomerInfo customerInfo);

}
