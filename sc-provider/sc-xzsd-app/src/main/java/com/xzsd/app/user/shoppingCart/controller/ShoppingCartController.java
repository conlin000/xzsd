package com.xzsd.app.user.shoppingCart.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.user.shoppingCart.entity.ShoppingCartInfo;
import com.xzsd.app.user.shoppingCart.entity.ShoppingCartListVO;
import com.xzsd.app.user.shoppingCart.service.ShoppingCartService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/shoppingCart")
public class ShoppingCartController {


    @Resource
    private ShoppingCartService shoppingCartService;


    /**
     * 购物车新增
     * @description 购物车新增
     * @function addShoppingCart
     * @param shoppingCartInfo (goodsCode, goodsCount)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("addShoppingCart")
    public AppResponse addShoppingCart(ShoppingCartInfo shoppingCartInfo){
        try {
            return shoppingCartService.addShoppingCart(shoppingCartInfo);
        }catch (Exception e){
            System.out.println("新增失败");
            throw e;
        }
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
    @PostMapping("removeShoppingCart")
    public AppResponse removeShoppingCart(String shoppingCartId){
        try {
            return shoppingCartService.removeShoppingCart(shoppingCartId);
        }catch (Exception e){
            System.out.println("删除失败");
            throw e;
        }
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
    @PostMapping("updateGoodsCount")
    public AppResponse updateGoodsCount(String shoppingCartId, String goodsCount){
        try {
            return shoppingCartService.updateGoodsCount(shoppingCartId, goodsCount);
        }catch (Exception e){
            System.out.println("修改失败");
            throw e;
        }
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
    @PostMapping("shoppingCartWithList")
    public AppResponse shoppingCartWithList(ShoppingCartListVO shoppingCartListVO){
        try {
            return shoppingCartService.shoppingCartWithList(shoppingCartListVO);
        }catch (Exception e){
            System.out.println("查询失败");
            throw e;
        }
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
    @PostMapping("checkShoppingCart")
    public AppResponse checkShoppingCart(String shoppingCartId){
        try {
            return shoppingCartService.checkShoppingCart(shoppingCartId);
        }catch (Exception e){
            System.out.println("失败");
            throw e;
        }
    }
}
