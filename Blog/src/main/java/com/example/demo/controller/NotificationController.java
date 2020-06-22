package com.example.demo.controller;

import com.example.demo.entity.Notification;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.NotificationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/17 16:00
 */
@Controller
@ResponseBody
public class NotificationController {
    @Resource
    private NotificationService notificationService;

    /**
     * 发表公告
     * @param notification
     * @return
     */
    @PostMapping(value = "/api/SystemPush")
    public Result SystemPush(@RequestBody Notification notification){
        notificationService.SystemPush(notification);
        return ResultFactory.buildSuccessResult(notification.getMessage());
    }

    /**
     * 未读通知统计
     * @return
     */
    @GetMapping(value = "/api/CountPush")
    public Result CountPush(){
        return ResultFactory.buildSuccessResult(notificationService.CountPush());
    }

    /**
     * 未读消息
     * @return
     */
    @GetMapping(value = "/api/unreadSysPush")
    public Result unreadSysPush(){
        return ResultFactory.buildSuccessResult(notificationService.unreadSysPush());
    }

    /**
     * 已读消息
     * @return
     */
    @GetMapping(value = "/api/readSysPush")
    public Result readSysPush(){
        return ResultFactory.buildSuccessResult(notificationService.readSysPush());
    }

    /**
     * 管理
     * @return
     */
    @GetMapping(value = "/api/selectSysPush")
    public Result selectSysPush(@RequestParam(value = "startTime",required = false)String startTime,
                                @RequestParam(value = "endTime",required = false)String endTime) {
        return ResultFactory.buildSuccessResult(notificationService.selectSysPush(startTime,endTime));
    }
}
