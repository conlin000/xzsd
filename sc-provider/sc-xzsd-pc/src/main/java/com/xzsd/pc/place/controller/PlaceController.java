package com.xzsd.pc.place.controller;

import com.neusoft.core.restful.AppResponse;
import com.xzsd.pc.place.entity.PlaceInfo;
import com.xzsd.pc.place.service.PlaceService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/place")
public class PlaceController {


    @Resource
    private PlaceService placeService;


    /**
     * 新增地级
     * @description 新增地级
     * @function addPlace
     * @param placeInfo (placeName, placeLevel, parentPlaceCode)
     * @type&return AppResponse
     * @author Conlin
     * @date
     */
    @PostMapping("addPlace")
    public AppResponse addPlace(PlaceInfo placeInfo){
        try {
            return placeService.addPlace(placeInfo);
        }catch (Exception e){
            System.out.println("新增失败");
            throw e;
        }
    }
}
