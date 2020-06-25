package com.example.demo.controller;

import com.example.demo.entity.CommentTop;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.CommentTopService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/25 18:04
 */
@Controller
@ResponseBody
public class CommentTopController {
    @Resource
    private CommentTopService commentTopService;

    @PostMapping(value = "/api/insertCommentTop")
    public Result insert(@RequestBody CommentTop commentTop){
        System.out.println(commentTop.getCid());
        commentTopService.insert(commentTop);
        return ResultFactory.buildSuccessResult("成功");
    }
    @PutMapping(value = "/api/updateCommentTop")
    public Result update(@RequestBody CommentTop commentTop){
        commentTopService.update(commentTop);
        return ResultFactory.buildSuccessResult("成功");
    }
}
