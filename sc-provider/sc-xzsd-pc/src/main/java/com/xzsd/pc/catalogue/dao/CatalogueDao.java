package com.xzsd.pc.catalogue.dao;



import com.xzsd.pc.catalogue.entity.CalalogueWithListVO;
import com.xzsd.pc.catalogue.entity.CatalogueInfo;
import com.xzsd.pc.catalogue.entity.QueryCatalogueVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@Mapper
public interface CatalogueDao {


    /**
     * 检查分类存在个数
     * @description 检查分类名字是否存在，若返回值 >0 则存在。
     * @function checkClassName
     * @param className, classLevel
     * @type&return int
     * @author Conlin
     * @date
     */
    int checkClassName(@Param("className") String className, @Param("classLevel") String classLevel);


    /**
     * 新增商品分类
     * @description 新增商品分类
     * @function addCatalogue
     * @param catalogueInfo
     * @type&return int
     * @author Conlin
     * @date
     */
    int addCatalogue(CatalogueInfo catalogueInfo);


    /**
     * 删除商品分类
     * @description 通过分类id删除商品分类
     * @function removeCatalogue
     * @param classId, userId
     * @type&return int
     * @author Conlin
     * @date
     */
    int removeCatalogue(@Param("classId") String classId, @Param("userId") String userId);


    /**
     * 修改商品分类信息
     * @description 通过分类id修改商品分类信息
     * @function updateCatalogue
     * @param catalogueInfo
     * @type&return int
     * @author Conlin
     * @date
     */
    int updateCatalogue(CatalogueInfo catalogueInfo);


    /**
     * 分类详情查询
     * @description 通过分类id查询分类，一次性传过去
     * @function queryClass
     * @param classCode
     * @type&return List<String>
     * @author Conlin
     * @date
     */
    // 用实体类CatalogueInfo类型也行
    List<QueryCatalogueVO> queryClass(String classCode);


    /**
     * 分类列表查询
     * @description 分类列表查询
     * @function classWithList
     * @param catalogueInfo
     * @type&return List<String>
     * @author Conlin
     * @date
     */
    List<CalalogueWithListVO> classWithList(CalalogueWithListVO catalogueInfo);
}
