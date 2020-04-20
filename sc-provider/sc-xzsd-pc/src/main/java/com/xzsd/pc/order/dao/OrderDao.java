package com.xzsd.pc.order.dao;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderWithListVO;
import com.xzsd.pc.order.entity.QueryOrderVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface OrderDao {

    /**
     * 订单（列表）查询
     * @description 订单（列表）查询,分页查询
     * @function ordersWithList
     * @param
     * @type&return
     * @author Conlin
     * @date
     */
    List<OrderWithListVO> ordersWithList(OrderWithListVO orderWithListVO);


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
     * @param
     * @type&return QueryOrderVO
     * @author Conlin
     * @date
     */
    QueryOrderVO queryOrder(QueryOrderVO vo);



    /**
     * 修改订单状态
     * @description 修改订单状态：订单状态：0-订单取消 1-订单到货 2-取消到货 3-订单已取货 4-取消已取货
     * @function updateOrderState
     * @param orderInfoList
     * @type&return int
     * @author Conlin
     * @date
     */
    int updateOrderState(OrderInfo orderInfoList);

}
