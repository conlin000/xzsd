package com.xzsd.pc.place.dao;


import com.xzsd.pc.place.entity.PlaceInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PlaceDao {


    /**
     * 检查地方
     * @description 检查地方是否存在，若不存在应该返回“0”
     * @function checkPlace
     * @param placeInfo (placeName, placeLevel, parentPlaceCode)
     * @type&return int
     * @author Conlin
     * @date
     */
    int checkPlace(PlaceInfo placeInfo);



    /**
     * 新增地方
     * @description 新增地方
     * @function addPlace
     * @param placeInfo
     * @type&return int
     * @author Conlin
     * @date
     */
    int addPlace(PlaceInfo placeInfo);
}
