package com.example.demo.dao;

import com.example.demo.entity.Notification;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/17 14:45
 */
public interface NotificationMapper {
    /**
     * 发布通知
     * @param notification
     */
    public void SystemPush(Notification notification);

    /**
     * 未读通知统计
     * @param uid
     * @return
     */
    public int CountPush(int uid);

    /**
     * 未读通知
     * @param uid
     * @return
     */
    public List<Notification> unreadSysPush(int uid);

    /**
     * 已读通知
     * @param uid
     * @return
     */
    public List<Notification> readSysPush(int uid);

    /**
     * 管理
     * @return
     */
    public List<Notification> selectSysPush(String startTime,String endTime);

}
