package com.xzsd.pc.place.service;


import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.StringUtil;
import com.xzsd.pc.place.dao.PlaceDao;
import com.xzsd.pc.place.entity.PlaceInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PlaceService {

    @Resource
    private PlaceDao placeDao;

    /**
     * 新增地级
     * @description 新增地级
     * @function addPlace
     * @param placeInfo
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    public AppResponse addPlace(PlaceInfo placeInfo){
        // 检查地方是否存在
        // 参数：(placeName, placeLevel, parentPlaceCode)
        int count = placeDao.checkPlace(placeInfo);
        if (count != 0){
            return AppResponse.duplicatError("该地方已存在！");
        }
        // 生成地方编号
        String placeCode = StringUtil.asYouLike(4, 8);
        // 配置地方编号
        placeInfo.setPalceCode(placeCode);
        // 新增地方
        int flagCount = placeDao.addPlace(placeInfo);
        if (flagCount == 0){
            return AppResponse.bizError("新增失败");
        }
        return AppResponse.success("新增成功");

    }
}
