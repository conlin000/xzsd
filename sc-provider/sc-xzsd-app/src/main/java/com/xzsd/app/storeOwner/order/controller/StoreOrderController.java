package com.xzsd.app.storeOwner.order.controller;


import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.storeOwner.order.entity.OrderListVO;
import com.xzsd.app.storeOwner.order.entity.UpdateOrderVO;
import com.xzsd.app.storeOwner.order.service.StoreOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/storeOwner/order")
public class StoreOrderController {


    @Resource
    private StoreOrderService storeOrderService;


    /**
     * App店长端订单查询
     * @description App店长端订单查询(店长只能看到自己门店的订单)
     * @function orderWithList
     * @param orderListVO (keyWord, orderState, paymentState, pageNum, pageSize)
     * @type&return
     * @author Conlin
     * @date
     */
    @PostMapping("ordersWithList")
    public AppResponse orderWithList(OrderListVO orderListVO){
        try {
            return storeOrderService.orderWithList(orderListVO);
        }catch(Exception e) {
            System.out.println("查询失败");
            throw e;
        }
    }


    /**
     * App店长端订单详情查询
     * @description App店长端订单详情查询
     * @function storeQueryOrder
     * @param (orderCode)
     * @type&return
     * @author Conlin
     * @date
     */
    @PostMapping("queryOrder")
    public AppResponse storeQueryOrder(String orderCode){
        try {
            return storeOrderService.storeQueryOrder(orderCode);
        }catch(Exception e) {
            System.out.println("查询失败");
            throw e;
        }
    }


    /**
     * App店长端“完成取货”
     * @description App店长端“完成取货”
     * @function updateOrder
     * @param updateOrderVO (orderCode, version)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("updateOrderState")
    public AppResponse updateOrder(UpdateOrderVO updateOrderVO){
        try {
            return storeOrderService.updateOrder(updateOrderVO);
        }catch(Exception e) {
            System.out.println("失败");
            throw e;
        }
    }
}
