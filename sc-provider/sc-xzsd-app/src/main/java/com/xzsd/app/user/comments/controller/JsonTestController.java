package com.xzsd.app.user.comments.controller;

import com.neusoft.core.restful.AppResponse;
import com.neusoft.util.JsonUtils;
import com.xzsd.app.user.comments.entity.AppCommentInfoVO;
import com.xzsd.app.user.comments.entity.AppOrderCommentVO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/JsonTest")
public class JsonTestController {

    @PostMapping("testJson")
    public AppResponse JsonTest(){
        //
        AppOrderCommentVO orderCommentVO = new AppOrderCommentVO();
        // 配置
        orderCommentVO.setUserCode("123");
        orderCommentVO.setUseName("asd");
        orderCommentVO.setOrderCode("123000");
        // 再配
        AppCommentInfoVO commentInfoVO = new AppCommentInfoVO();
        List<AppCommentInfoVO> commentInfoVOS = new ArrayList<>();
        commentInfoVO.setCommentCode("1111111233");
        commentInfoVO.setGoodsCode("asd12345");
        commentInfoVO.setScore(2);
        commentInfoVO.setComment("wa呜呜呜");
        commentInfoVOS.add(commentInfoVO);
        // 还配
        List<String> imgList = new ArrayList<>();
        imgList.add("https://12345/4566");
        //
        commentInfoVO.setImagePath(imgList);
        orderCommentVO.setCommentInfoVOList(commentInfoVOS);

        return AppResponse.success("test",orderCommentVO);
    }

    /**
     * {\"userCode\":\"123\",\"useName\":\"哟嚯？\",\"orderCode\":\"123000\",\"commentInfoVOList\":[{\"commentCode\":\"1111111233\",\"goodsCode\":\"asd12345\",\"score\":2,\"comment\":\"wa呜呜呜\",\"imagePath\":[\"https://12345/4566\"]}],\"isDeleted\":0,\"version\":0}
     * @return
     */
    @PostMapping("toJson")
    public AppResponse toJson(){
        //
        AppOrderCommentVO orderCommentVO = new AppOrderCommentVO();
        // 配置
        orderCommentVO.setUserCode("123");
        orderCommentVO.setUseName("哟嚯？");
        orderCommentVO.setOrderCode("123000");
        // 再配
        AppCommentInfoVO commentInfoVO = new AppCommentInfoVO();
        List<AppCommentInfoVO> commentInfoVOS = new ArrayList<>();
        commentInfoVO.setCommentCode("1111111233");
        commentInfoVO.setGoodsCode("asd12345");
        commentInfoVO.setScore(2);
        commentInfoVO.setComment("wa呜呜呜");
        commentInfoVOS.add(commentInfoVO);
        // 还配
        List<String> imgList = new ArrayList<>();
        imgList.add("https://12345/4566");
        //
        commentInfoVO.setImagePath(imgList);
        orderCommentVO.setCommentInfoVOList(commentInfoVOS);

        // toJson
        String json = JsonUtils.toJson(orderCommentVO);
        System.out.println("==================================================");
        System.out.println("==================================================");
        System.out.println(json);
        return AppResponse.success("1", json);
    }


    @PostMapping("fromJson")
    public AppResponse fromJson(String json){

       AppOrderCommentVO orderCommentVO = JsonUtils.fromJson(json, AppOrderCommentVO.class);
       return AppResponse.success("1", orderCommentVO);
    }


}
