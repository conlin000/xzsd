package com.xzsd.pc.catalogue.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.catalogue.entity.CalalogueWithListVO;
import com.xzsd.pc.catalogue.entity.CatalogueInfo;
import com.xzsd.pc.catalogue.service.CatalogueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@RestController
@RequestMapping("/catalogue")
public class CatalogueController {




    // 日志spring boot自带
    private static final Logger logger = LoggerFactory.getLogger(CatalogueController.class);

    @Resource
    private CatalogueService catalogueService;

    /**
     * 新增商品分类
     * @description 新增商品分类
     * @function addCatalogue
     * @param parentClassCode, className, note
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("addClass")
    public AppResponse addCatalogue(String parentClassCode, String className, String note){

        try {
            return catalogueService.addCatalogue(parentClassCode, className, note);
        }catch (Exception e){
            logger.error("新增失败！", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 删除商品分类
     * @description 通过分类id删除商品分类
     * @function removeCatalogue
     * @param classId
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("removeClass")
    public AppResponse removeCatalogue(String classId){

        try {
            return catalogueService.removeCatalogue(classId);
        }catch (Exception e){
            logger.error("删除失败");
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 修改商品分类信息
     * @description 通过classCode修改商品分类信息(className, note, version)
     * @function updateCatalogue
     * @param catalogueInfo
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("updateClass")
    public AppResponse updateCatalogue(CatalogueInfo catalogueInfo){

        try {
            return catalogueService.updateCatalogue(catalogueInfo);
        }catch (Exception e){
            logger.error("修改失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 分类详情查询
     * @description 通过分类id查询分类，一次性传过去
     * @function queryClass
     * @param classCode
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("queryClass")
    public AppResponse queryClass(String classCode){
        try{
            return catalogueService.queryClass(classCode);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }


    /**
     * 分类列表查询
     * @description 分类列表查询
     * @function classWithList
     * @param catalogueInfo
     * @type&return List<String>
     * @author Conlin
     * @date
     */
    @PostMapping("classWithList")
    public AppResponse classWithList(CalalogueWithListVO catalogueInfo){
        try {
            return catalogueService.classWithList(catalogueInfo);
        }catch (Exception e){
            logger.error("查询失败", e);
            System.out.println(e.toString());
            throw e;
        }
    }
}
