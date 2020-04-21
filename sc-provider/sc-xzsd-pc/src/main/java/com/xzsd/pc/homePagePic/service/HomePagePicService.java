package com.xzsd.pc.homePagePic.service;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.homePagePic.dao.HomePagePicDao;
import com.xzsd.pc.homePagePic.entity.GoodsChoosingVO;
import com.xzsd.pc.homePagePic.entity.ImageInfo;
import com.xzsd.pc.homePagePic.entity.ImagesWithListVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;


@Service
public class HomePagePicService {


    @Resource
    private HomePagePicDao homePagePicDao;

    /**
     * 首页轮播图新增
     * @description 首页轮播图新增
      @function addHomePagePic
     * @param imageInfo (imagePath, sortNo, effectiveOn, effectiveEnd, goodsCode)
     * @tpye&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHomePagePic(ImageInfo imageInfo) {
        // 一个商品只能有一张轮播图
        int count = homePagePicDao.checkGoods(imageInfo.getGoodsCode());
        if (count != 0){
            return AppResponse.bizError("该商品已有轮播图!");
        }
        // 检查排序号是否存在，若不存在应返回“0”
        count = homePagePicDao.checkSortNo(imageInfo.getSortNo());
        if (count != 0){
            return AppResponse.bizError("该排序号已存在!");
        }
        // 用工具类生成图片编码
        imageInfo.setImageCode(StringUtil.getCommonCode(2));
        imageInfo.setIsDeleted(0);
        // 获取当前用户，记录创建人或修改人
        String userId = SecurityUtils.getCurrentUserId();
        imageInfo.setCreator(userId);
        imageInfo.setModifiedBy(userId);
        // 新增首页轮播图
        count = homePagePicDao.addHomePagePic(imageInfo);
        if (count == 0) {
            return AppResponse.bizError("新增首页轮播图失败");
        }
        return AppResponse.success(" 新增首页轮播图成功");
    }


    /**
     * 首页轮播图新增 -- 商品选择(分页查询)
     *
     * @param goodsChoosingVO
     * @description 首页轮播图新增的“商品选择”(分页查询)
     * @function goodsChoosing
     * @tpye&return List<GoodsChoosingVO>
     * @author Conlin
     * @date
     */
    public AppResponse goodsChoosing(GoodsChoosingVO goodsChoosingVO) {
        // 分页查询
        PageHelper.startPage(goodsChoosingVO.getPageNum(), goodsChoosingVO.getPageSize());
        // 商品选择
        List<GoodsChoosingVO> goodsInfoList = homePagePicDao.goodsChoosing(goodsChoosingVO);
        // 包装Page对象
        PageInfo<GoodsChoosingVO> pageInfo = new PageInfo<GoodsChoosingVO>(goodsInfoList);
        return AppResponse.success("查询成功", pageInfo);
    }


    /**
     * 首页轮播图删除
     *
     * @param imageCode
     * @description 首页轮播图删除，通过图片的id删除
     * @function removeHomePagePic
     * @tpye&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse removeHomePagePic(String imageCode) {
        // 获取当前用户id，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 把传递过来的imageCode以‘，’分割，装进列表
        List<String> imageCodeList = Arrays.asList(imageCode.split(","));
        int count = homePagePicDao.removeHomePagePic(imageCodeList, userId);
        if (count == 0) {
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");
    }


    /**
     * 首页轮播图状态修改
     * @description 首页轮播图状态修改，通过图片的id修改。图片状态 0-禁用  1-启用
     * @function updatePicState
     * @tpye&return int
     * @param imageInfo (imageCode, imageState, version
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updatePicState(ImageInfo imageInfo) {
        // 获取当前用户id，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 配置实体类
        imageInfo.setModifiedBy(userId);
        // 分割轮播图编号
        List<String> imageCodeList = Arrays.asList(imageInfo.getImageCode().split(","));
        // 修改首页轮播图状态
        int count = homePagePicDao.updatePicState(imageInfo);
        if (count == 0) {
            return AppResponse.versionError("数据有变化，修改状态失败");
        }else if (count != imageCodeList.size()){
            return AppResponse.versionError("某条数据修改失败，请复查");
        }
        return AppResponse.success("修改状态成功");
    }


    /**
     * 首页轮播图（列表）查询
     * @description 首页轮播图（列表）查询(分页查询)
     * @function imagesWithList
     * @tpye&return AppResponse
     * @param imageInfo
     * @author Conlin
     * @date
     */
    public AppResponse imagesWithList(ImagesWithListVO imageInfo){
        // 分页查询
        PageHelper.startPage(imageInfo.getPageNum(), imageInfo.getPageSize());
        List<ImagesWithListVO> imageInfoList = homePagePicDao.imagesWithList(imageInfo);
        // 包装Page对象
        PageInfo<ImagesWithListVO> pageData = new PageInfo<>(imageInfoList);
        return AppResponse.success("查询成功", pageData);
    }
}
