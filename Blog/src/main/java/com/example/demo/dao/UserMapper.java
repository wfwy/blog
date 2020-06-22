package com.example.demo.dao;

import com.example.demo.entity.User;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/13 14:16
 */
public interface UserMapper {
    List<User> findAll();
    User findByName(String username);
    void addUser(User user);
}
