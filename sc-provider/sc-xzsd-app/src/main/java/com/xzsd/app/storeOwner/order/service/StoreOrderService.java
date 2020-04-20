package com.xzsd.app.storeOwner.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.app.storeOwner.order.dao.StoreOrderDao;
import com.xzsd.app.storeOwner.order.entity.OrderListVO;
import com.xzsd.app.storeOwner.order.entity.StoreQueryOrderVO;
import com.xzsd.app.storeOwner.order.entity.UpdateOrderVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StoreOrderService {


    @Resource
    private StoreOrderDao storeOrderDao;


    /**
     * App店长端订单查询
     * @description App店长端订单查询(店长只能看到自己门店的订单)
     * @function orderWithList
     * @param orderListVO (keyWord, orderState, paymentState, pageNum, pageSize)
     * @type&return
     * @author Conlin
     * @date
     */
    public AppResponse orderWithList(OrderListVO orderListVO){
        // 获取当前用户(店长只能看到自己门店的订单)
        orderListVO.setCurrentUserCode(SecurityUtils.getCurrentUserId());
        // 订单查询
        List<OrderListVO> orderListVOList = storeOrderDao.orderWithList(orderListVO);
        return AppResponse.success("查询成功", orderListVOList);
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
    public AppResponse storeQueryOrder(String orderCode){
        /*
        获取订单信息
         */
        StoreQueryOrderVO queryOrderVO = new StoreQueryOrderVO();
        // 配置订单编码
        queryOrderVO.setOrderCode(orderCode);
        // 获取订单信息
        queryOrderVO = storeOrderDao.storeQueryOrder(queryOrderVO);
        /*
        查询店铺信息
         */
        // 获取当前店长编码
        String userCode = SecurityUtils.getCurrentUserId();
        // 获取门店信息
        StoreQueryOrderVO voTemp = storeOrderDao.getStoreInfo(userCode);
        // 配置门店信息
        queryOrderVO.setStoreCode(voTemp.getStoreCode());
        queryOrderVO.setStoreName(voTemp.getStoreName());
        queryOrderVO.setStoreAddress(voTemp.getStoreAddress());
        // 返回订单详情
        return AppResponse.success("成功", queryOrderVO);
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
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrder(UpdateOrderVO updateOrderVO){
        // 获取当前用户，配置修改者
        updateOrderVO.setLastModifiedBy(SecurityUtils.getCurrentUserId());
        // “完成取货”
        int flagCount = storeOrderDao.updateOrder(updateOrderVO);
        if (flagCount == 0){
            return AppResponse.versionError("数据有变，请刷新（或该数据已被删除）");
        }
        return AppResponse.success("成功");
    }


}
