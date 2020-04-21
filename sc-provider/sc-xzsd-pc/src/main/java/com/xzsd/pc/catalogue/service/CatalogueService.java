package com.xzsd.pc.catalogue.service;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.security.client.utils.SecurityUtils;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.catalogue.dao.CatalogueDao;
import com.xzsd.pc.catalogue.entity.CalalogueWithListVO;
import com.xzsd.pc.catalogue.entity.CatalogueInfo;
import com.xzsd.pc.catalogue.entity.QueryCatalogueVO;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@Service
public class CatalogueService {


    @Resource
    private CatalogueDao catalogueDao;


    /**
     * 新增商品分类
     * @description 新增商品分类
     * @function addCatalogue
     * @param parentClassCode, className, note
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse addCatalogue(String parentClassCode, String className, String note){

        CatalogueInfo catalogueInfo = new CatalogueInfo();

        // 获取当前用户，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();
        catalogueInfo.setCreator(userId);
        catalogueInfo.setModifiedBy(userId);

        // 检查是“一级分类”还是“二级分类”
        if (parentClassCode == null || parentClassCode == ""){

            // 一级分类
            // 检查分类是否存在
            int count = catalogueDao.checkClassName(className, "1");
            if (count > 0){
                return AppResponse.bizError("新增失败，此分类已存在！(或者输入的父类已被删除)");
            }
            // 将参数装进实体类
            catalogueInfo.setClassName(className);
            catalogueInfo.setNote(note);
            // 设置分类等级为“一级”
            catalogueInfo.setClassLevel(1);
            // 使用工具类生成分类编码
            String classCode = StringUtil.getCommonCode(2);
            catalogueInfo.setClassCode(classCode);
        }
        else {
            // 二级分类
            // 检查分类是否存在
            int count = catalogueDao.checkClassName(className, "2");
            if (count > 0){
                return AppResponse.bizError("新增失败，此分类已存在！(或者输入的父类已被删除)");
            }

            // 将参数装进实体类
            catalogueInfo.setParentClassCode(parentClassCode);
            catalogueInfo.setClassName(className);
            catalogueInfo.setNote(note);
            // 设置分类等级为“二级”
            catalogueInfo.setClassLevel(2);

            // 使用工具类生成分类编码
            String classCode = StringUtil.getCommonCode(2);
            catalogueInfo.setClassCode(classCode);
        }
        // 新增分类
        int count = catalogueDao.addCatalogue(catalogueInfo);
        if (count == 0){
            return AppResponse.bizError("新增失败！");
        }

        return AppResponse.success("新增成功！");
    }


    /**
     * 删除商品分类
     * @description 通过分类id删除商品分类
     * @function removeCatalogue
     * @param classId, userId
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse removeCatalogue(String classId){

        // 获取当前用户id，记录创建者或修改者
        String userId = SecurityUtils.getCurrentUserId();

        int count = catalogueDao.removeCatalogue(classId, userId);
        if (count == 0){
            return AppResponse.bizError("删除失败");
        }

        return AppResponse.success("删除成功");
    }


    /**
     * 修改商品分类信息
     * @description 通过分类id修改商品分类信息
     * @function updateCatalogue
     * @param catalogueInfo
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @Transactional(rollbackFor = Exception.class)
    public AppResponse updateCatalogue(CatalogueInfo catalogueInfo){

        // 使用工具类获取当前用户id，记录修改者或创建者
        String userId = SecurityUtils.getCurrentUserId();
        catalogueInfo.setModifiedBy(userId);

        int count =  catalogueDao.updateCatalogue(catalogueInfo);
        if (count == 0){
            return AppResponse.versionError("修改失败(或该数据已被删除)");
        }
        return AppResponse.success("修改成功");
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
    public AppResponse queryClass(String classCode){

        List<QueryCatalogueVO> stringList = catalogueDao.queryClass(classCode);
        return AppResponse.success("查询成功", stringList);
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
    public AppResponse classWithList(CalalogueWithListVO catalogueInfo){

        List<CalalogueWithListVO> catalogueInfos = catalogueDao.classWithList(catalogueInfo);
        return AppResponse.success("查询成功", catalogueInfos);
    }

//    /**
//     * 变成树
//     * @description 把数据变成"树"的形式(要在实体类里添加子级List<>字段)
//     * @function toTree
//     * @param
//     * @type&return List<String>
//     * @author Conlin
//     * @date
//     */
//    public List<CalalogueWithListVO> toTree(List<CalalogueWithListVO> data, List<CalalogueWithListVO> tree){
//
//        // 找到最高级
//        for (int i = 0; i < data.size(); i++) {
//            if (data.get(i).getParentClassCode() == null || data.get(i).getParentClassCode() == ""){
//
//                tree.add(data.get(i));
//
//                // 删除已添加的元素,减少查询次数
//                data.remove(i);
//                // 一定要i--,因为删除list会自动把数据补上空缺的位置;
//                i--;
//            }
//        }
//        // 找子级
//        findSon(data, tree);
//        // 返回树
//        return tree;
//
//    }
//
//
//    /**
//     * 找子级
//     * @description 找子级
//     * @function findSon
//     * @param
//     * @type&return
//     * @author Conlin
//     * @date
//     */
//    public void findSon(List<CalalogueWithListVO> data, List<CalalogueWithListVO> son){
//
//        // 找子级
//        for (int j = 0; j < son.size(); j++) {
//
//            // 唯一出口,当子级为空时结束递归
//            if (son.get(j).getClassCode() == null || son.get(j).getClassCode() == "") {
//                return;
//            }
//
//            // 声明子列表
//            List<CalalogueWithListVO> sonList = new ArrayList<>();
//            for (int i = 0; i < data.size(); i++) {
//                // 如果找到父级
//                if (data.get(i).getClassCode() != null && data.get(i).getParentClassCode().equals(son.get(j).getClassCode())) {
//
//                    // 装进子列表
//                    sonList.add(data.get(i));
//                    // 删除,减少查询次数
//                    data.remove(i);
//
//                    // 一定要i--,因为删除list会自动把数据补上空缺的位置;
//                    i = i - 1;
//
//                }
//            }
//            // 配置子列表
//            son.get(j).setSon(sonList);
//            // 递归找子级
//            findSon(data, sonList);
//        }
//
//    }
}
