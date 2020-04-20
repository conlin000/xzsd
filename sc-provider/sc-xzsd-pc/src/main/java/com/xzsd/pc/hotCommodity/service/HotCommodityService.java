package com.xzsd.pc.hotCommodity.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.hotCommodity.dao.HotCommodityDao;
import com.xzsd.pc.hotCommodity.entity.GoodsChoosingVO;
import com.xzsd.pc.hotCommodity.entity.HotCommodityInfo;
import com.xzsd.pc.hotCommodity.entity.HotCommodityListVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;

@Service
public class HotCommodityService {


    @Resource
    private HotCommodityDao hotCommodityDao;


    /**
     * 热门位商品位新增 -- 商品选择(分页查询)
     * @description 热门位商品位新增 -- 商品选择(分页查询)
     * @function choosingGoods
     * @tpye&return AppResponse
     * @param goodsInfo
     * @author Conlin
     * @date
     */
    public AppResponse goodsChoosing(GoodsChoosingVO goodsInfo) {
        // 分页查询
        PageHelper.startPage(goodsInfo.getPageNum(), goodsInfo.getPageSize());
        // 商品选择
        List<GoodsChoosingVO> goodsInfoList = hotCommodityDao.goodsChoosing(goodsInfo);
        // 包装Page对象
        PageInfo<GoodsChoosingVO> pageInfo = new PageInfo<GoodsChoosingVO>(goodsInfoList);
        return AppResponse.success("查询成功", pageInfo);
    }



    /**
     * 热门位商品位新增
     * @description 热门位商品位新增，热门位排序号：0-无排序
     * @function addHotCommodity
     * @tpye&return int
     * @param
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addHotCommodity(HotCommodityInfo hotCommodityInfo){
        // 查询商品编号是否存在
        String goodsCode = hotCommodityInfo.getGoodsCode();
        int count = hotCommodityDao.checkGoodsCode(goodsCode);
        if (count != 0){
            return AppResponse.bizError("此商品已有热门位！");
        }
        // 查询热门位排序号是否存在
        int hotSortNo = hotCommodityInfo.getHotSortNo();
        int check = hotCommodityDao.checkHotSortNo(hotSortNo);
        if (check != 0){
            return AppResponse.bizError("热门位排序号已存在！");
        }
        // 使用工具类获取当前用户id，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 配置创建者
        hotCommodityInfo.setCreator(userId);
        // 使用工具类生成热门位商品id
        String hotCommodityId = StringUtil.asYouLike(3, 18);
        // 配置热门位商品id
        hotCommodityInfo.setHotCommodityID(hotCommodityId);
        // 热门位商品位新增
        int flageCount = hotCommodityDao.addHotCommodity(hotCommodityInfo);
        if (flageCount == 0){
            return AppResponse.bizError("新增热门位失败");
        }
        return AppResponse.success("新增热门位成功");
    }



    /**
     * 热门位商品位删除
     * @description 热门位商品位删除
     * @function removeHotCommodity
     * @tpye&return AppResponse
     * @param | hotCommodityID, userId
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse removeHotCommodity(String hotCommodityID){
        // 使用工具类获取当前用户id，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 分割热门位商品编号字符串，装进LIST
        List<String> hotCommodityIDList = Arrays.asList(hotCommodityID.split(","));
        // 热门位商品位删除
        int flagCount = hotCommodityDao.removeHotCommodity(hotCommodityIDList, userId);
        if (flagCount == 0){
            return AppResponse.bizError("删除失败");
        }
        return AppResponse.success("删除成功");

    }



    /**
     * 热门位商品位修改
     * @description 热门位商品位修改
     * @function updateHotCommodity
     * @tpye&return AppResponse
     * @param hotCommodityInfo
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateHotCommodity(HotCommodityInfo hotCommodityInfo){

        String goodsCode = hotCommodityInfo.getGoodsCode();
        Integer hotSortNo = hotCommodityInfo.getHotSortNo();
        // 使用工具类获取当前用户id，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        // 配置修改者
        hotCommodityInfo.setModifiedBy(userId);
        if (goodsCode != null && goodsCode != ""){
            // 商品编号查重
            int count = hotCommodityDao.checkGoodsCode(goodsCode);
            if (count != 0){
                if (hotSortNo != null){
                    return AppResponse.bizError("此商品已有热门位！请直接修改排序号,无需再选择商品！");
                }
                return AppResponse.bizError("此商品已有热门位！");
            }
            // 获取商品信息
            HotCommodityInfo infoTemp = hotCommodityDao.getInfo(hotCommodityInfo);
            // 配置信息
            hotCommodityInfo.setGoodsName(infoTemp.getGoodsName());
            hotCommodityInfo.setSellingPrice(infoTemp.getSellingPrice());
            hotCommodityInfo.setBooksIntroduction(infoTemp.getBooksIntroduction());
        }
        // 交换热门序号
        if (hotSortNo != null){
            // 排序号查重
            int flagCount = hotCommodityDao.checkHotSortNo(hotSortNo);
            if (flagCount == 1){
                // 交换热门序号
                // getSomething
                HotCommodityInfo infoTemp = hotCommodityDao.getSomething(hotCommodityInfo);
                // 当需要更改的排序号不是自己本身才能交换
                if ( !hotSortNo.equals(infoTemp.getHotSortNo())){
                    // 配置修改者
                    infoTemp.setModifiedBy(userId);
                    // 热门位商品位修改
                    flagCount = hotCommodityDao.updateHotCommodity(infoTemp);
                    if (flagCount == 0){
                        return AppResponse.versionError("修改失败，请刷新！（或该数据已被删除）2");
                    }
                }
            }
        }
        // 热门位商品位修改
        int flagCount = hotCommodityDao.updateHotCommodity(hotCommodityInfo);
        if (flagCount == 0){
            return AppResponse.versionError("修改失败，请刷新！（或该数据已被删除）");
        }
        return AppResponse.success("修改成功");
    }



    /**
     * 热门位商品（列表）查询 + 展示数量修改
     * @description 热门位商品（列表）查询（分页查询） + 展示数量修改
     * @function hotCommodityWithList
     * @tpye&return AppResponse
     * @param hotCommodityInfo
     * @author Conlin
     * @date
     */
    public AppResponse hotCommodityWithList(HotCommodityListVO hotCommodityInfo){
        // 分页查询
        PageHelper.startPage(hotCommodityInfo.getPageNum(), hotCommodityInfo.getPageSize());
        // 热门位商品（列表）查询 + 展示数量修改
        List<HotCommodityListVO> data = hotCommodityDao.hotCommodityWithList(hotCommodityInfo);
        // 包装Page对象
        PageInfo<HotCommodityListVO> pageInfo = new PageInfo<HotCommodityListVO>(data);
        return AppResponse.success("查询成功", pageInfo);
    }
}
