package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.dao.UserRoleMapper;
import com.example.demo.entity.User;
import com.example.demo.entity.UserRole;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/13 14:18
 */
@Service
public class UserService {
    @Resource
    private UserMapper userMapper;
    @Resource
    private UserRoleMapper userRoleMapper;
    public List<User> findAll(){
        return userMapper.findAll();
    }
    public User findByName(String username){
        return userMapper.findByName(username);
    }
    public boolean isExist(String username) {
        User user = userMapper.findByName(username);
        return null != user;
    }
    public void addUser(User user){
        userMapper.addUser(user);
        int uid =user.getId();
        UserRole userRole = new UserRole();
        userRole.setUid(uid);
        userRole.setRid(2);
        userRoleMapper.addUserRole(userRole);
    }
}
