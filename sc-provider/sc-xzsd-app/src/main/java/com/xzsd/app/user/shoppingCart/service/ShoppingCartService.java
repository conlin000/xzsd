package com.xzsd.app.user.shoppingCart.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;

import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.app.user.shoppingCart.dao.ShoppingCartDao;
import com.xzsd.app.user.shoppingCart.entity.ShoppingCartInfo;
import com.xzsd.app.user.shoppingCart.entity.ShoppingCartListVO;
import com.xzsd.app.user.shoppingCart.entity.ShoppingCartSumPriceVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class ShoppingCartService {


    @Resource
    private ShoppingCartDao shoppingCartDao;


    /**
     * 购物车新增
     * @description 购物车新增
     * @function addShoppingCart
     * @param shoppingCartInfo (goodsCode, goodsCount)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse addShoppingCart(ShoppingCartInfo shoppingCartInfo){

        // 使用工具类获取当前用户，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 配置创建者
        shoppingCartInfo.setCreator(userId);
        // 配置当前用户
        shoppingCartInfo.setUserCode(userId);
        // 使用工具类生成购物车id
        String shoppingCartId = StringUtil.getCommonCode(2);
        // 配置购物车id
        shoppingCartInfo.setShoppingCartId(shoppingCartId);
        // 购物车新增
        int flagCount = shoppingCartDao.addShoppingCart(shoppingCartInfo);
        if (flagCount == 0){
            return AppResponse.bizError("新增购物车失败");
        }
        return AppResponse.success("新增购物车成功");
    }


    /**
     * 购物车删除
     * @description 购物车删除
     * @function removeShoppingCart
     * @param shoppingCartId
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse removeShoppingCart(String shoppingCartId){
        // 分割购物车id
        List<String> shoppingCartIdList = Arrays.asList(shoppingCartId.split(","));
        // 购物车删除
        int flagCount = shoppingCartDao.removeShoppingCart(shoppingCartIdList);
        if (flagCount == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }


    /**
     * 修改商品数量
     * @description 修改商品数量
     * @function updateGoodsCount
     * @param shoppingCartId, goodsCount
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse updateGoodsCount(String shoppingCartId, String goodsCount){
        // 修改商品数量
        int flagCount = shoppingCartDao.updateGoodsCount(shoppingCartId, goodsCount);
        if (flagCount == 0){
            return AppResponse.bizError("修改失败");
        }
        return AppResponse.success("√");
    }


    /**
     * 合计购物车价格查询
     * @description 被选中的购物车查询，计算被选中的购物车数量和总价格
     * @function checkShoppingCart
     * @param shoppingCartId
     * @type&return int
     * @author Conlin
     * @date
     */
    public AppResponse checkShoppingCart(String shoppingCartId){

        // 分割购物车id，装进list
        List<String> shoppingCartIdList = Arrays.asList(shoppingCartId.split(","));
        // 获取当前用户id
        String userCode = SecurityUtils.getCurrentUserId();
        // 被选中的购物车查询
        List<ShoppingCartSumPriceVO> shoppingCarts = shoppingCartDao.checkShoppingCart(shoppingCartIdList, userCode);
        // 声明变量
        float sumPrice = 0;
        int shoppingCartCount = 0;
        // 选中的购物车数量
        shoppingCartCount = shoppingCarts.size();
        // 计算合计价格
        for (ShoppingCartSumPriceVO s : shoppingCarts){
            sumPrice += s.getTotalPrice();
        }
        return AppResponse.success("ok", "shoppingCartCount: " + shoppingCartCount + "," + "  &  " + "sumPrice: " + sumPrice);
    }


    /**
     * 购物车（列表）查询
     * @description 购物车（列表）查询，分页查询
     * @function shoppingCartWithList
     * @param shoppingCartListVO (pageNum, pageSize)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse shoppingCartWithList(ShoppingCartListVO shoppingCartListVO){
        // 获得当前用户id
        shoppingCartListVO.setUserCode(SecurityUtils.getCurrentUserId());
        // 分页查询
        PageHelper.startPage(shoppingCartListVO.getPageNum(), shoppingCartListVO.getPageSize());
        // 获取数据库数据
        List<ShoppingCartInfo> shoppingCartInfoList = shoppingCartDao.shoppingCartWithList(shoppingCartListVO);
        // 包装page对象
        PageInfo<ShoppingCartInfo> pageInfo = new PageInfo<>(shoppingCartInfoList);
        // 如果page为空
        if (pageInfo == null){
            return AppResponse.bizError("查询失败");
        }
        // 返回
        return AppResponse.success("√", pageInfo);
    }
}
