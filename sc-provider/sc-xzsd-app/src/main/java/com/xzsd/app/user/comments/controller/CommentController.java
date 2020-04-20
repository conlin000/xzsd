package com.xzsd.app.user.comments.controller;
import com.neusoft.core.restful.AppResponse;
import com.xzsd.app.user.comments.entity.CommentWithListVO;
import com.xzsd.app.user.comments.service.CommentService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user/comments")
public class CommentController {


    @Resource
    private CommentService commentService;



    /**
     * 商品评论（列表）查询
     * @description 商品评论（列表）查询,分页查询
     * @function commentsWithList
     * @param commentWithListVO (goodsCode, score, pageNum, pageSize)
     * @type&return List<CommentWithListVO>
     * @author Conlin
     * @date
     */
    @PostMapping("commentsWithList")
    public AppResponse commentsWithList(CommentWithListVO commentWithListVO){
        try {
            return commentService.commentsWithList(commentWithListVO);
        }catch (Exception e){
            System.out.println("查询失败");
            throw e;
        }
    }



    /**
     * app用户端订单评论
     * @description app用户端订单评论
     * @function orderComment
     * @param commentJson
     * @type&return int
     * @author Conlin
     * @date
     */
    @PostMapping("orderComment")
    public AppResponse orderComment(String commentJson){
        try {
            return commentService.orderComment(commentJson);
        }catch(Exception e) {
            System.out.println("失败");
            throw e;
        }
    }
}
