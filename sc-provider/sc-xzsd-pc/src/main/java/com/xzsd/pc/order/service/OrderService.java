package com.xzsd.pc.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.xzsd.pc.order.dao.OrderDao;
import com.xzsd.pc.order.entity.OrderInfo;
import com.xzsd.pc.order.entity.OrderWithListVO;
import com.xzsd.pc.order.entity.QueryOrderVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;


@Service
public class OrderService {


    @Resource
    private OrderDao orderDao;


    /**
     * 订单（列表）查询
     * @description 订单（列表）查询,分页查询
     * @function ordersWithList
     * @param orderWithListVO
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse ordersWithList(OrderWithListVO orderWithListVO){

        // 获取当前用户编码（店长只能看到自己门店的订单，管理员能看到全部）(非数据库字段,用于查询)
        String currentUser = SecurityUtils.getCurrentUserId();
        // 配置当前用户
        orderWithListVO.setCurrentUserCode(currentUser);
        // 分页查询
        PageHelper.startPage(orderWithListVO.getPageNum(), orderWithListVO.getPageSize());
        // 订单（列表）查询
        List<OrderWithListVO> orderList = orderDao.ordersWithList(orderWithListVO);
        // 包装Page对象
        PageInfo<OrderWithListVO> pageInfo = new PageInfo<>(orderList);
        return AppResponse.success("查询成功", pageInfo);
    }


    /**
     * 订单详情查询
     * @description 订单详情查询
     * @function queryOrder
     * @param orderCode
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse queryOrder(String orderCode){

        QueryOrderVO vo = new QueryOrderVO();
        // 配置订单编号
        vo.setOrderCode(orderCode);
//        // 配置当前用户
//        vo.setUserCode(SecurityUtils.getCurrentUserId());
        // 查询订单详情
        vo = orderDao.queryOrder(vo);
        return AppResponse.success("查询成功", vo);
    }



    /**
     * 修改订单状态
     * @description 修改订单状态：订单状态：0-订单取消 1-订单到货 2-取消到货 3-订单已取货 4-取消已取货
     * @function updateOrderState
     * @param orderInfo
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateOrderState(OrderInfo orderInfo){


        // 使用工具类获取当前用户id，用于修改创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 配置修改者
        orderInfo.setLastModifiedBy(userId);
        // 修改订单状态
        int flagCount = orderDao.updateOrderState(orderInfo);
        if (flagCount == 0){
            return AppResponse.versionError("修改订单状态失败，请刷新！（或该数据已被删除）");
        }
        return AppResponse.success("修改订单状态成功");
    }
}
