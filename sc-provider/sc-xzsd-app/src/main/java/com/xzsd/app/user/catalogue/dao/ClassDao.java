package com.xzsd.app.user.catalogue.dao;
import com.xzsd.app.user.catalogue.entity.FirClassVO;
import com.xzsd.app.user.catalogue.entity.SecClassVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClassDao {


    /**
     * 一级分类查询
     * @description 一级分类查询
     * @function firClass
     * @param firClassVO
     * @type&return List<FirClassVO>
     * @author Conlin
     * @date
     */
    List<FirClassVO> firClass(FirClassVO firClassVO);


    /**
     * 二级分类商品查询
     * @description 二级分类查询
     * @function secClass
     * @param secClassVO
     * @type&return List<SecClassVO>
     * @author Conlin
     * @date
     */
    List<SecClassVO> secClass(SecClassVO secClassVO);



//    /**
//     * App商品分类查询
//     * @description App商品分类查询
//     * @function viewCommodity
//     * @param viewCommodityVO
//     * @type&return List<ViewCommodityVO>
//     * @author Conlin
//     * @date
//     */
//    List<ViewCommodityVO> viewCommodity(ViewCommodityVO viewCommodityVO);
}
