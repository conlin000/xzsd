package com.xzsd.app.user.catalogue.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.user.catalogue.entity.FirClassVO;
import com.xzsd.app.user.catalogue.entity.SecClassVO;
import com.xzsd.app.user.catalogue.service.ClassService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/catalogue")
public class ClassController {


    @Resource
    private ClassService classService;


    /**
     * 一级分类查询
     * @description 一级分类查询
     * @function firClass
     * @param firClassVO
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("firClass")
    public AppResponse firClass(FirClassVO firClassVO){
        try {
            return classService.firClass(firClassVO);
        }catch (Exception e){
            System.out.println("查询失败");
            throw e;
        }
    }


    /**
     * 二级分类查询
     * @description 二级分类查询
     * @function secClassGoods
     * @param secClassVO (parentClassCode)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("secClassGoods")
    public AppResponse secClassGoods(SecClassVO secClassVO){
        try {
            return classService.secClass(secClassVO);
        }catch (Exception e){
            System.out.println("查询失败");
            throw e;
        }
    }


//    /**
//     * App商品分类查询
//     * @description App商品分类查询
//     * @function viewCommodity
//     * @param viewCommodityVO (secClassCode, pageNum, pageSize)
//     * @type&return AppResponse
//     * @author Conlin
//     * @date
//     */
//    @PostMapping("viewCommodity")
//    public AppResponse viewCommodity(ViewCommodityVO viewCommodityVO){
//        try {
//            return classService.viewCommodity(viewCommodityVO);
//        }catch (Exception e){
//            System.out.println("查询失败");
//            throw e;
//        }
//    }
}
