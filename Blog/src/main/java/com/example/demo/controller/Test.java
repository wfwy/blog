package com.example.demo.controller;

import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/20 11:21
 */
@Controller
@ResponseBody
public class Test {
    @GetMapping(value = "/api/test")
    public Result test(@RequestParam(value = "date1",required = false)String timestamp1,
                       @RequestParam(value = "date2",required = false)String timestamp2){
        System.out.println(timestamp1);
        System.out.println(timestamp2);
        String timestamp =timestamp1;
        return ResultFactory.buildSuccessResult(timestamp);
    }
}
