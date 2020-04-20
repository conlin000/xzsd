package com.xzsd.app.storeOwner.order.dao;



import com.xzsd.app.storeOwner.order.entity.OrderListVO;
import com.xzsd.app.storeOwner.order.entity.StoreQueryOrderVO;
import com.xzsd.app.storeOwner.order.entity.UpdateOrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreOrderDao {

    /**
     * App店长端订单(列表)查询
     * @description App店长端订单(列表)查询，分页查询
     * @function orderWithList
     * @param orderListVO (keyWord, orderState, paymentState, pageNum, pageSize)
     * @type&return List<OrderListVO>
     * @author Conlin
     * @date
     */
    List<OrderListVO> orderWithList(OrderListVO orderListVO);


    /**
     * App店长端订单详情查询
     * @description App店长端订单详情查询
     * @function storeQueryOrder
     * @param storeQueryOrderVO
     * @type&return
     * @author Conlin
     * @date
     */
    StoreQueryOrderVO storeQueryOrder(StoreQueryOrderVO storeQueryOrderVO);


    /**
     * App店长端订单详情查询==>获得订单门店信息
     * @description App店长端订单详情查询==>获得订单门店信息
     * @function getStoreInfo
     * @param userCode
     * @type&return
     * @author Conlin
     * @date
     */
    StoreQueryOrderVO getStoreInfo(String userCode);


    /**
     * App店长端“完成取货”
     * @description App店长端“完成取货”
     * @function updateOrder
     * @param updateOrderVO (orderCode, version)
     * @type&return
     * @author Conlin
     * @date
     */
    int updateOrder(UpdateOrderVO updateOrderVO);


}
