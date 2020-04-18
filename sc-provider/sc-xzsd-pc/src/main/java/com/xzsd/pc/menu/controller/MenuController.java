package com.xzsd.pc.menu.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.menu.entity.MenuByRoleVO;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.entity.MenuWithListVO;
import com.xzsd.pc.menu.service.MenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/menu")
public class MenuController {


    @Resource
    private MenuService menuService;


    // 日志spring boot自带
    private static final Logger logger = LoggerFactory.getLogger(MenuController.class);



    /**
     * 新增菜单
     * @description 新增菜单
     * @function addMenu
     * @param
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("addMenu")
    public AppResponse addMenu(MenuInfo menuInfo){

        try {
            return menuService.addMenu(menuInfo);
        }catch (Exception e){
            logger.error("新增菜单失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 删除菜单
     * @description 新增菜单
     * @function removeMenu
     * @param menuId
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("removeMenu")
    public AppResponse removeMenu(String menuId){

        try {
            return menuService.removeMenu(menuId);
        }catch (Exception e){
            logger.error("删除菜单失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 修改菜单信息
     * @description 修改菜单信息
     * @function updateMenu
     * @param menuInfo(menuId, menuName, menuLevel, menuPath, comments, version)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("updateMenu")
    public AppResponse updateMenu(MenuInfo menuInfo){

        try {
            return menuService.updateMenu(menuInfo);
        }catch (Exception e){
            logger.error("修改菜单失败，请刷新版本！（或该数据已被删除）", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 查询菜单信息
     * @description 查询菜单信息
     * @function queryMenu
     * @param menuId
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("queryMenu")
    public AppResponse queryMenu(String menuId){

        try {
            return menuService.queryMenu(menuId);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 根据角色返回菜单选项（列表）查询
     * @description 根据角色返回菜单选项（列表）查询
     * @function menuByRole
     * @param menuByRoleVO (role)
     * @type&return List<MenuWithListVO>
     * @author Conlin
     * @date
     */
    @PostMapping("menuByRole")
    public AppResponse menuByRole(MenuByRoleVO menuByRoleVO){
        try {
            return menuService.menuByRole(menuByRoleVO);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 菜单（列表）查询
     * @description 菜单（列表）查询
     * @function menuWithList
     * @param
     * @type&return
     * @author Conlin
     * @date
     */
    @PostMapping("menuWithList")
    public AppResponse menuWithList(MenuWithListVO menuWithListVO){

        try {
            return menuService.menuWithList(menuWithListVO);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
