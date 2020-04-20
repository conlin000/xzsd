package com.xzsd.pc.order.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderWithListVO;
import com.xzsd.pc.order.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/orders")
public class OrderController {


    @Resource
    private OrderService orderService;


    // spring boot  自带日志
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);



    /**
     * 订单（列表）查询
     * @description 订单（列表）查询,分页查询
     * @function ordersWithList
     * @param orderWithListVO
     * (userName, orderCode, phone, paidDateOn, paidDateEnd, orderState, pageNum, pageSize)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("ordersWithList")
    public AppResponse ordersWithList(OrderWithListVO orderWithListVO){

        try {
            return orderService.ordersWithList(orderWithListVO);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 订单状态下拉查询
     * @description 订单状态下拉查询
     * @function orderStateDropDownQuery
     * @param orderWithListVO
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    // 待定，考虑是否需要实现



    /**
     * 订单详情查询
     * @description 订单详情查询
     * @function queryOrder
     * @param orderCode
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("queryOrder")
    public AppResponse queryOrder(String orderCode){

        try {
            return orderService.queryOrder(orderCode);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }



    /**
     * 修改订单状态
     * @description 修改订单状态：订单状态：0-订单取消 1-订单到货 2-取消到货 3-订单已取货 4-取消已取货
     * @function updateOrderState
     * @param orderInfo (orderCode, orderState, version)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrderState(OrderInfo orderInfo){

        try {
            return orderService.updateOrderState(orderInfo);
        }catch (Exception e){
            logger.error("修改订单状态失败，请刷新！（或该数据已被删除）", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
