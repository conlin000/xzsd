package com.xzsd.pc.menu.service;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.menu.dao.MenuDao;
import com.xzsd.pc.menu.entity.MenuByRoleVO;
import com.xzsd.pc.menu.entity.MenuInfo;
import com.xzsd.pc.menu.entity.MenuWithListVO;
import com.xzsd.pc.menu.entity.QueryMenuVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MenuService {


    @Resource
    private MenuDao menuDao;



    /**
     * 新增菜单
     * @description 新增菜单
     * @function addMenu
     * @param menuInfo
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addMenu(MenuInfo menuInfo){

        // 用工具类获取当前用户id，记录创建者和修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 使用工具类生成菜单编码id
        String menuId = StringUtil.getCommonCode(1);
        // 设置创建者或修改者
        menuInfo.setCreator(userId);
        // 设置菜单编码id
        menuInfo.setMenuId(menuId);

        // 检查菜单存在个数
        String menuName = menuInfo.getMenuName();
        int menuCount = menuDao.checkMenu(menuName);
        if (menuCount != 0){
            return AppResponse.bizError("该菜单或目录已存在！");
        }

        // 新增菜单
        int flag = menuDao.addMenu(menuInfo);
        if (flag == 0){
            return AppResponse.bizError("新增菜单失败");
        }
        return AppResponse.success("新增菜单成功");
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
    @Transactional(rollbackFor = Exception.class)
    public AppResponse removeMenu(String menuId){

        // 用工具类获取当前用户ID，用于记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();

        // 删除菜单
        int flagCount = menuDao.removeMenu(menuId, userId);
        if (flagCount == 0){
            return AppResponse.bizError("删除菜单失败！");
        }
        return AppResponse.success("删除菜单成功！");
    }


    /**
     * 修改菜单信息
     * @description 修改菜单信息
     * @function updateMenu
     * @param menuInfo
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateMenu(MenuInfo menuInfo){

        // 使用工具类获取当前用户id，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 设置修改者
        menuInfo.setLastModifiedBy(userId);


        int flagCount = menuDao.updateMenu(menuInfo);
        if (flagCount == 0){
            return  AppResponse.versionError("修改菜单失败，请刷新版本！（或该数据已被删除）");
        }
        return AppResponse.success("修改菜单成功");
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
    public AppResponse queryMenu(String menuId){

        List<QueryMenuVO> menuInfo = menuDao.queryMenu(menuId);
        return AppResponse.success("查询成功", menuInfo);
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
    public AppResponse menuByRole(MenuByRoleVO menuByRoleVO){
        int role = menuByRoleVO.getRole();
        if (role < 0 || role > 3){
            return AppResponse.success("角色不存在");
        }
        // 根据角色返回菜单选项（列表）查询
        List<MenuByRoleVO> menuData = menuDao.menuByRole(menuByRoleVO);
        return AppResponse.success("查询成功",menuData);
    }


    /**
     * 菜单（列表）查询
     * @description 菜单（列表）查询
     * @function menuWithList
     * @param
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse menuWithList(MenuWithListVO menuWithListVO){

        List<MenuWithListVO> menuData =  menuDao.menuWithList(menuWithListVO);
        return AppResponse.success("查询成功",menuData);
    }
}
