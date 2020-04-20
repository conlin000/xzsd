package com.xzsd.app.user.order.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.JsonUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.user.order.dao.AppUserOrderDao;
import com.xzsd.app.user.order.entity.*;

import com.xzsd.app.user.shoppingCart.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AppUserOrderService {

    @Resource
    private AppUserOrderDao appUserOrderDao;


    /**
     * app“立即购买”
     * @description
     * @function fastOrder
     * @param
     * @type&return int
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse fastOrder(String goodsCode, int goodsCount){

        /*
         加入购物车
          */
        ShoppingCartInfo shoppingCartInfo = new ShoppingCartInfo();
        // 配置商品数量
        shoppingCartInfo.setGoodsCount(goodsCount);
        // 配置商品编码
        shoppingCartInfo.setGoodsCode(goodsCode);
        // 使用工具类获取当前用户，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 配置创建者
        shoppingCartInfo.setCreator(userId);
        // 配置当前用户
        shoppingCartInfo.setUserCode(userId);
        // 配置当前用户名称
        shoppingCartInfo.setUserName(SecurityUtils.getCurrentUserUsername());
        // 使用工具类生成购物车id
        String shoppingCartId = StringUtil.getCommonCode(2);
        // 配置购物车id
        shoppingCartInfo.setShoppingCartId(shoppingCartId);
        // 购物车新增
        int flagCount = appUserOrderDao.addCart(shoppingCartInfo);
        if (flagCount == 0){
            return AppResponse.bizError("fast下单失败");
        }
        // 订单新增
        addOrder(shoppingCartId);
        return AppResponse.success("fast下单成功");
    }


    /**
     * app订单新增
     * @description 订单新增（“立即购买”按钮或者“购物车”下单）
     * @function addOrder
     * @param shoppingCartId
     * @type&return int
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addOrder(String shoppingCartId){

        // 使用工具类获得当前用户，修改创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 配置创建者和下单人
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreator(userId);
        orderInfo.setUserCode(userId);
        // 配置购物车id
        orderInfo.setShoppingCartId(shoppingCartId);
        // 生成订单编号
        String orderCode = StringUtil.getCommonCode(2);
        // 配置订单编号
        orderInfo.setOrderCode(orderCode);
        /*
        计算订单总价
         */
        float sumPrice = 0;
        List<String> shoppingCartIdList = new ArrayList<>();
        // 分割购物车id，装进list
        shoppingCartIdList = Arrays.asList(shoppingCartId.split(","));
        // 计算订单总价
        sumPrice = appUserOrderDao.getPriceByShoppingCart(shoppingCartIdList);
        // 查询并统计订单的商品数量
        List<Integer> goodsCountList = appUserOrderDao.getGoodsCount(shoppingCartIdList);
        Integer goodsCount = 0;
        for (Integer i : goodsCountList){
            goodsCount += i;
        }
        // 配置订单的商品数量
        orderInfo.setGoodsCount(goodsCount);
        // 配置订单总价
        orderInfo.setTotalPrice(sumPrice);
        // 订单新增
        int flagCount = appUserOrderDao.addOrder(orderInfo);
        if (flagCount == 0){
            return AppResponse.bizError("下单失败");
        }
        // 购物车和订单关联,购物车修改为已结算
        appUserOrderDao.doUpdate(shoppingCartIdList, orderCode);
        return AppResponse.success("下单成功");

    }


    /**
     * 订单详情查询
     * @description 订单详情查询（一个订单对多个）
     * @function queryOrder
     * @param orderVO (queryOrder)
     * @type&return QueryOrderVO
     * @author Conlin
     * @date
     */
    public AppResponse queryOrder(QueryOrderVO orderVO){
        // 配置当前用户
        orderVO.setUserCode(SecurityUtils.getCurrentUserId());
        // 订单详情查询
        orderVO = appUserOrderDao.queryOrder(orderVO);
        // 查找店铺信息
        QueryOrderVO storeInfo = appUserOrderDao.getStoreInfo(SecurityUtils.getCurrentUserId());
        // 配置门店地址信息
        orderVO.setStoreCode(storeInfo.getStoreCode());
        orderVO.setStoreName(storeInfo.getStoreName());
        orderVO.setStoreAddress(storeInfo.getStoreAddress());
        // 返回订单详情
        return AppResponse.success("成功", orderVO);
    }



    /**
     * app订单(列表)查询
     * @description 订单(列表)查询，分页查询（一个订单对多个）
     * @function ordersWithList
     * @param orderListVO (pageNum, pageSize)
     * @type&return List<OrderListVO>
     * @author Conlin
     * @date
     */
    public AppResponse ordersWithList(OrderListVO orderListVO){

        // 获取当前用户
        orderListVO.setUserCode(SecurityUtils.getCurrentUserId());

        // 分页查询
        PageHelper.startPage(orderListVO.getPageNum(), orderListVO.getPageSize());
        List<OrderListVO> dataList = appUserOrderDao.ordersWithList(orderListVO);
        // 包装page对象
        PageInfo<OrderListVO> pageInfo = new PageInfo<>(dataList);
        if (pageInfo == null){
            return AppResponse.bizError("查询失败");
        }
        return AppResponse.success("查询成功", pageInfo);
    }




}
