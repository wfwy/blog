package com.example.demo.controller;

import com.example.demo.entity.UserNotification;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.UserNotificationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/18 15:30
 */
@Controller
@ResponseBody
public class UserNotificationController {
    @Resource
    UserNotificationService userNotificationService;
    @PutMapping(value = "/api/unReadUpdate")
    public Result unReadUpdate(@RequestBody UserNotification userNotification){
        System.out.println("test："+ userNotification.getNid());
        int nid = userNotification.getNid();
        userNotificationService.unReadUpdate(nid);
        return ResultFactory.buildSuccessResult("成功");
    }
}
