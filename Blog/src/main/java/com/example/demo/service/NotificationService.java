package com.example.demo.service;

import com.example.demo.dao.NotificationMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.dao.UserNotificationMapper;
import com.example.demo.entity.Notification;
import com.example.demo.entity.User;
import com.example.demo.entity.UserNotification;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/17 14:46
 */
@Service
public class NotificationService {
    @Resource
    private NotificationMapper notificationMapper;
    @Resource
    private UserNotificationMapper userNotificationMapper;
    @Resource
    private UserMapper userMapper;

    /**
     * 发布通知
     * @param notification
     */
    public void SystemPush(Notification notification){
        String author = (String) SecurityUtils.getSubject().getPrincipal();
        notification.setAuthor(author);
        notificationMapper.SystemPush(notification);
        int nid = notification.getId();
        int state = 0;
        List<User> user = userMapper.findAll();
        UserNotification userNotification = new UserNotification();
        for (User user1 : user){
            userNotification.setNid(nid);
            userNotification.setUid(user1.getId());
            userNotification.setState(state);
            userNotificationMapper.SystemPush(userNotification);
        }
    }

    /**
     * 未读通知统计
     * @return
     */
    public int CountPush(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int uid = userMapper.findByName(username).getId();
        return notificationMapper.CountPush(uid);
    }

    /**
     * 未读通知
     * @return
     */
    public List<Notification> unreadSysPush(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int uid = userMapper.findByName(username).getId();
        return notificationMapper.unreadSysPush(uid);
    }

    /**
     * 已读通知
     * @return
     */
    public List<Notification> readSysPush(){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int uid = userMapper.findByName(username).getId();
        return notificationMapper.readSysPush(uid);
    }

    /**
     * 管理
     * @return
     */
    public List<Notification> selectSysPush(String startTime,String endTime){
        return notificationMapper.selectSysPush(startTime,endTime);
    }
}
