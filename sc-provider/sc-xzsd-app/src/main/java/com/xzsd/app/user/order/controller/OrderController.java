package com.xzsd.app.user.order.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.user.order.entity.OrderListVO;
import com.xzsd.app.user.order.entity.QueryOrderVO;
import com.xzsd.app.user.order.service.AppUserOrderService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/order")
public class OrderController {

    @Resource
    private AppUserOrderService appUserOrderService;


    /**
     * app-订单新增
     * @description 订单新增（“立即购买”按钮或者“购物车”下单）
     * @function addOrder
     * @param shoppingCartId
     * @type&return int
     * @author Conlin
     * @date
     */
    @PostMapping("addOrder")
    public AppResponse addOrder(String shoppingCartId){
        try {
            return appUserOrderService.addOrder(shoppingCartId);
        }catch(Exception e){
            System.out.println("新增失败");
            throw e;
        }
    }

    /**
     * app“立即购买”
     * @description
     * @function fastOrder
     * @param goodsCode, goodsCount
     * @type&return int
     * @author Conlin
     * @date
     */
    @PostMapping("fastOrder")
    public AppResponse fastOrder(String goodsCode, int goodsCount){
        try {
            return appUserOrderService.fastOrder(goodsCode, goodsCount);
        }catch(Exception e){
            System.out.println("失败");
            throw e;
        }
    }


    /**
     * 订单(列表)查询
     * @description 订单(列表)查询，分页查询（一个订单对多个）
     * @function ordersWithList
     * @param orderListVO (pageNum, pageSize)
     * @type&return List<OrderListVO>
     * @author Conlin
     * @date
     */
    @PostMapping("ordersWithList")
    public AppResponse ordersWithList(OrderListVO orderListVO){
        try {
            return appUserOrderService.ordersWithList(orderListVO);
        }catch(Exception e) {
            System.out.println("查询失败");
            throw e;
        }
    }


    /**
     * 订单详情查询
     * @description 订单详情查询（一个订单对多个）
     * @function queryOrder
     * @param orderVO (orderCode)
     * @type&return QueryOrderVO
     * @author Conlin
     * @date
     */
    @PostMapping("queryOrder")
    public AppResponse queryOrder(QueryOrderVO orderVO){
        try {
            return appUserOrderService.queryOrder(orderVO);
        }catch(Exception e) {
            System.out.println("查询失败");
            throw e;
        }
    }


}
