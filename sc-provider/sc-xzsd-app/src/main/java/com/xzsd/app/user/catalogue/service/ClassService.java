package com.xzsd.app.user.catalogue.service;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.user.catalogue.dao.ClassDao;
import com.xzsd.app.user.catalogue.entity.FirClassVO;
import com.xzsd.app.user.catalogue.entity.SecClassVO;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ClassService {


    @Resource
    private ClassDao classDao;


    /**
     * 一级分类查询
     * @description 一级分类查询
     * @function firClass
     * @param firClassVO
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse firClass(FirClassVO firClassVO){

        List<FirClassVO> list = classDao.firClass(firClassVO);
        return AppResponse.success("查询成功", list);
    }



    /**
     * 二级分类查询
     * @description 二级分类查询
     * @function secClass
     * @param secClassVO
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse secClass(SecClassVO secClassVO){

        if (secClassVO.getParentClassCode() == null || secClassVO.getParentClassCode() == ""){
            return AppResponse.bizError("查询失败");
        }
        List<SecClassVO> list = classDao.secClass(secClassVO);

        return AppResponse.success("查询成功", list);
    }


//
//    /**
//     * App商品分类查询
//     * @description App商品分类查询
//     * @function viewCommodity
//     * @param viewCommodityVO
//     * @type&return AppResponse
//     * @author Conlin
//     * @date
//     */
//    public AppResponse viewCommodity(ViewCommodityVO viewCommodityVO){
//
//        List<ViewCommodityVO> list = classDao.viewCommodity(viewCommodityVO);
//
//        return AppResponse.success("查询成功", list);
//    }

}
