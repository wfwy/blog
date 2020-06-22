package com.example.demo.dao;

import com.example.demo.entity.Role;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/13 19:09
 */
public interface RoleMapper {
    List<Role> findRolebyName(String username);
}
