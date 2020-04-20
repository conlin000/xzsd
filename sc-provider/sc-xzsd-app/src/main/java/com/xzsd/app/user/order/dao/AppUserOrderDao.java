package com.xzsd.app.user.order.dao;

import com.xzsd.app.user.order.entity.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AppUserOrderDao {

    /**
     * 合计订单价格（购物车下单）
     * @description 合计订单价格（购物车下单）
     * @function getPrice
     * @param shoppingCartId
     * @type&return int
     * @author Conlin
     * @date
     */
    float getPriceByShoppingCart(@Param("shoppingCartId") List<String> shoppingCartId);



    /**
     * app-用户端：订单新增 ==> 获得商品数量
     * @description 订单新增（“立即购买”按钮或者“购物车”下单）
     * @function getGoodsCount
     * @param shoppingCartId
     * @type&return List<Integer>
     * @author Conlin
     * @date
     */
    List<Integer> getGoodsCount(@Param("shoppingCartId") List<String> shoppingCartId);


    /**
     * 订单新增
     * @description 订单新增（“立即购买”按钮或者“购物车”下单）
     * @function addOrder
     * @param orderInfo (shoppingCartId, goodsCode)
     * @type&return int
     * @author Conlin
     * @date
     */
    int addOrder(OrderInfo orderInfo);


    /**
     * app“立即购买” -- 购物车新增
     * @description 购物车新增
     * @function addShoppingCart
     * @param shoppingCartInfo (goodsCode, goodsCount)
     * @type&return int
     * @author Conlin
     * @date
     */
    int addCart(ShoppingCartInfo shoppingCartInfo);



    /**
     * 修改数据库信息
     * @description 购物车结算修改：0-未结算 1-已结算,并添加订单关联。库存要相应减少
     * @function doUpdate
     * @param shoppingCartIdList, orderCode
     * @type&return int
     * @author Conlin
     * @date
     */
    int doUpdate(@Param("shoppingCartIdList") List<String> shoppingCartIdList, @Param("orderCode") String orderCode);


    /**
     * app-用户端：订单详情查询
     * @description 订单详情查询（一个订单对多个）
     * @function queryOrder
     * @param queryOrderVO (orderId, userCode)
     * @type&return QueryOrderVO
     * @author Conlin
     * @date
     */
    QueryOrderVO queryOrder(QueryOrderVO queryOrderVO);


    /**
     * app-用户端：订单详情查询 ==> 查找门店地址信息
     * @description 订单详情查询（一个订单对多个）
     * @function getStoreInfo
     * @param
     * @type&return
     * @author Conlin
     * @date
     */
    QueryOrderVO getStoreInfo(String userCode);


    /**
     * 订单(列表)查询
     * @description 订单(列表)查询，分页查询（一个订单对多个）
     * @function ordersWithList
     * @param orderListVO (pageNum, pageSize)
     * @type&return List<OrderListVO>
     * @author Conlin
     * @date
     */
    List<OrderListVO> ordersWithList(OrderListVO orderListVO);



}
