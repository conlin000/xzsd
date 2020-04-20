package com.xzsd.pc.menu.dao;

import com.xzsd.pc.menu.entity.MenuByRoleVO;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.entity.MenuWithListVO;
import com.xzsd.pc.menu.entity.QueryMenuVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuDao {


    /**
     * 菜单存在个数
     * @description 检查菜单存在个数，若不存在应返回‘0’
     * @function checkMenu
     * @param menuName
     * @type&return int
     * @author Conlin
     * @date
     */
    int checkMenu(String menuName);



    /**
     * 新增菜单
     * @description 新增菜单
     * @function addMenu
     * @param menuInfo
     * @type&return int
     * @author Conlin
     * @date
     */
    int addMenu(MenuInfo menuInfo);


    /**
     * 删除菜单
     * @description 删除菜单
     * @function removeMenu
     * @param menuId, userId
     * @type&return int
     * @author Conlin
     * @date
     */
    int removeMenu(@Param("menuId") String menuId, @Param("userId") String userId);


    /**
     * 修改菜单信息
     * @description 修改菜单信息
     * @function updateMenu
     * @param menuInfo
     * @type&return int
     * @author Conlin
     * @date
     */
    int updateMenu(MenuInfo menuInfo);


    /**
     * 查询菜单信息
     * @description 查询菜单信息
     * @function queryMenu
     * @param menuId
     * @type&return QueryMenuVO
     * @author Conlin
     * @date
     */
    List<QueryMenuVO> queryMenu(String menuId);


    /**
     * 根据角色返回菜单选项（列表）查询
     * @description 根据角色返回菜单选项（列表）查询
     * @function menuByRole
     * @param menuByRoleVO (role
     * @type&return List<MenuWithListVO>
     * @author Conlin
     * @date
     */
    List<MenuByRoleVO> menuByRole(MenuByRoleVO menuByRoleVO);


    /**
     * 菜单（列表）查询
     * @description 菜单（列表）查询
     * @function menuWithList
     * @param menuWithListVO
     * @type&return
     * @author Conlin
     * @date
     */
    List<MenuWithListVO> menuWithList(MenuWithListVO menuWithListVO);
}
