package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.dao.UserNotificationMapper;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/17 15:11
 */
@Service
public class UserNotificationService {
    @Resource
    private UserNotificationMapper userNotificationMapper;
    @Resource
    UserMapper userMapper;
    public void unReadUpdate(int nid){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int uid = userMapper.findByName(username).getId();
        System.out.println(uid);
        userNotificationMapper.unReadUpdate(nid,uid);
    }
}
