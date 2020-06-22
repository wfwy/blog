package com.example.demo.dao;

import com.example.demo.entity.UserNotification;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/17 15:08
 */
public interface UserNotificationMapper {
    public void SystemPush(UserNotification userNotification);
    public void unReadUpdate(int nid,int uid);
}
