package com.xzsd.pc.goods.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.goods.dao.GoodsDao;
import com.xzsd.pc.goods.entity.ClassChooseVO;
import com.xzsd.pc.goods.entity.GoodsInfo;
import com.xzsd.pc.goods.entity.GoodsWithListVO;
import com.xzsd.pc.goods.entity.QueryGoodsVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class GoodsService {


    @Resource
    private GoodsDao goodsDao;



    /**
     * 商品新增
     * @description 新增商品
     * @function addGoods
     * @tpye&return AppResponse
     * @param goodsInfo
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addGoods (GoodsInfo goodsInfo){
        // 检查书名是否存在
        int count = goodsDao.checkBookName(goodsInfo);
        if (count != 0){
            return AppResponse.duplicatError("此书已存在！");
        }
        // 检查ISBN书号是否存在
        count = goodsDao.checkISBN(goodsInfo);
        if (count != 0){
            return AppResponse.duplicatError("ISBN书号已存在！");
        }
        // 用工具类生成商品编号
        goodsInfo.setGoodsCode(StringUtil.getCommonCode(2));
        goodsInfo.setIsDeleted(0);
        // 获取当前用户id，记录修改者或创建者
        String userId = SecurityUtils.getCurrentUserId();
        goodsInfo.setCreator(userId);
        goodsInfo.setModifiedBy(userId);
        // 新增商品
        int addCount = goodsDao.addGoods(goodsInfo);
        if (addCount == 0){
            return AppResponse.bizError("新增商品失败！");
        }
        return AppResponse.success("新增商品成功！");
    }


    /**
     *商品删除
     * @description 删除商品
     * @function removeGoods
     * @tpye&return AppResponse
     * @param goodsCode, goodsCode
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse removeGoods(String goodsCode, String userId){
        // 把传过来的商品编号以‘，’分割，存进列表里
        List<String> listGoodsCode = Arrays.asList(goodsCode.split(","));
        // 检查商品是否可删除，如果没有包含“热门位商品”或者“首页轮播图”则返回“0”
        int count = goodsDao.checkGoods(listGoodsCode);
        if (count != 0){
            return AppResponse.bizError("删除商品失败！删除的商品包含“热门位”商品或者“首页轮播图”商品");
        }
        count = goodsDao.removeGoods(listGoodsCode, userId);
        if (count == 0){
            return AppResponse.bizError("删除商品失败！");
        }
        return AppResponse.success("删除成功！");
    }


    /**
     * 商品（列表）查询
     * @description 商品查询，使用到分页查询
     * @function goodsWithList
     * @tpye&return AppResponse
     * @param goodsInfo
     * @author Conlin
     * @date
     */
    public AppResponse goodsWithList(GoodsWithListVO goodsInfo){
        // 分页查询
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        List<GoodsWithListVO> goodsInfoList = goodsDao.goodsWithList(goodsInfo);
        // 包装Page对象
        PageInfo<GoodsWithListVO> pageInfo = new PageInfo<>(goodsInfoList);
        return AppResponse.success("查询成功", pageInfo);
    }


    /**
     * 商品详情查询
     * @description 商品详情查询
     * @function queryGoods
     * @tpye&return AppResponse
     * @param goodsCode
     * @author Conlin
     * @date
     */
    public AppResponse queryGoods(String goodsCode){
        // 商品详情查询
        QueryGoodsVO goodsInfo =  goodsDao.queryGoods(goodsCode);
        return AppResponse.success("查询成功", goodsInfo);
    }


    /**
     * 商品信息修改
     * @description 商品详情查询
     * @function updateGoods
     * @tpye&return AppResponse
     * @param goodsInfo
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateGoods(GoodsInfo goodsInfo){
        // 获取当前用户，记录修改者或创建者
        String userId = SecurityUtils.getCurrentUserId();
        // 配置修改者
        goodsInfo.setModifiedBy(userId);
        // 商品信息修改
        int count =  goodsDao.updateGoods(goodsInfo);
        if (count == 0){
            return AppResponse.versionError("数据有变化，请刷新！(或数据已被删除)");
        }
        return AppResponse.success("修改成功");
    }


    /**
     * 修改商品状态
     * @description 商品状态：1-在售  2-已下架  3-未发布
     * @function changeGoodsState
     * @tpye&return AppResponse
     * @param goodsInfo (goodsCodes, goodsState, version)
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse changeGoodsState(GoodsInfo goodsInfo){
        // 获取当前用户，修改创建者或修改者。
        String userId = SecurityUtils.getCurrentUserId();
        // 配置实体类
        goodsInfo.setModifiedBy(userId);
        // 分割商品编号字符串
        List<String> goodsCodeList = Arrays.asList(goodsInfo.getGoodsCode().split(","));
        // 修改商品状态
        int count = goodsDao.changeGoodsState(goodsInfo);
        if (count == 0){
            return AppResponse.versionError("数据有变化，请刷新！（或数据已被删除）");
        }else if (count != goodsCodeList.size()){
            return AppResponse.versionError("某条数据修改失败，请复查");
        }
        return AppResponse.success("修改成功");
    }


    /**
     * 一级分类下拉查询
     * @description 新增商品时的一级分类查询接口
     * @function firClassChoosing
     * @tpye&return AppResponse
     * @param classChooseVO
     * @author Conlin
     * @date
     */
    public AppResponse firClassChoosing(ClassChooseVO classChooseVO){
        //
        List<ClassChooseVO> classNameList = goodsDao.firClassChoosing(classChooseVO);
        return AppResponse.success("查询成功", classNameList);
    }


    /**
     * 二级分类下拉查询
     * @description 新增商品时的二级分类查询接口
     * @function secClassChoosing
     * @tpye&return AppResponse
     * @param parentClassCode
     * @author Conlin
     * @date
     */
    public AppResponse secClassChoosing(String parentClassCode){
        //
        List<ClassChooseVO> classNameList = goodsDao.secClassChoosing(parentClassCode);
        return AppResponse.success("查询成功", classNameList);
    }
}
