package com.xzsd.pc.hotCommodity.dao;

import com.xzsd.pc.hotCommodity.entity.GoodsChoosingVO;
import com.xzsd.pc.hotCommodity.entity.HotCommodityInfo;
import com.xzsd.pc.hotCommodity.entity.HotCommodityListVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface HotCommodityDao {


    /**
     * 热门位排序号查询
     * @description 热门位排序号查询，若不存在应返回“0”
     * @function checkHotSortNo
     * @tpye&return int
     * @param hotSortNo
     * @author Conlin
     * @date
     */
        int checkHotSortNo(String hotSortNo);


    /**
     * 热门位商品编号查询
     * @description 热门位商品编号查询，若不存在应返回“0”
     * @function checkGoodsCode
     * @tpye&return int
     * @param goodsCode
     * @author Conlin
     * @date
     */
    int checkGoodsCode(String goodsCode);


    /**
     * 热门位商品位新增 -- 商品选择(分页查询)
     * @description 热门位商品位新增 -- 商品选择(分页查询)
     * @function choosingGoods
     * @tpye&return List<GoodsChoosingVO>
     * @param goodsChoosingVO
     * @author Conlin
     * @date
     */
    List<GoodsChoosingVO> goodsChoosing(GoodsChoosingVO goodsChoosingVO);


    /**
     * 热门位商品位新增
     * @description 热门位商品位新增，热门位排序号：0-无排序
     * @function addHotCommodity
     * @tpye&return int
     * @param hotCommodityInfo
     * @author Conlin
     * @date
     */
    int addHotCommodity(HotCommodityInfo hotCommodityInfo);



    /**
     * 热门位商品位删除
     * @description 热门位商品位删除
     * @function removeHotCommodity
     * @tpye&return int
     * @param | hotCommodityID, userId
     * @author Conlin
     * @date
     */
    int removeHotCommodity(@Param("hotCommodityID") List<String> hotCommodityID, @Param("userId") String userId);

    /**
     * 热门位商品位修改 ==> 查询商品信息
     * @description 热门位商品位修改
     * @function getInfo
     * @tpye&return HotCommodityInfo
     * @param hotCommodityInfo
     * @author Conlin
     * @date
     */
    HotCommodityInfo getInfo(HotCommodityInfo hotCommodityInfo);


    /**
     * 热门位商品位修改
     * @description 热门位商品位修改
     * @function updateHotCommodity
     * @tpye&return int
     * @param hotCommodityInfo
     * @author Conlin
     * @date
     */
    int updateHotCommodity(HotCommodityInfo hotCommodityInfo);



    /**
     * 热门位商品（列表）查询 + 展示数量修改
     * @description 热门位商品（列表）查询（分页查询） + 展示数量修改
     * @function hotCommodityWithList
     * @tpye&return List<HotCommodityListVO>
     * @param hotCommodityInfo
     * @author Conlin
     * @date
     */
    List<HotCommodityListVO> hotCommodityWithList(HotCommodityListVO hotCommodityInfo);

}
