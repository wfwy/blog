package com.example.demo.controller;

import com.example.demo.entity.Comment;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.CommentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/21 16:46
 */
@Controller
@ResponseBody
public class CommentController {
    @Resource
    private CommentService commentService;
    @PostMapping(value = "/api/insertComment")
    public Result insertComment(@RequestBody Comment comment){
        commentService.insertComment(comment);
        return ResultFactory.buildSuccessResult("成功");
    }
    @GetMapping(value = "/api/listComment")
    public Result listComment(@RequestParam(value = "aid", required = false) int aid){
        return ResultFactory.buildSuccessResult(commentService.listComment(aid));
    }
}
