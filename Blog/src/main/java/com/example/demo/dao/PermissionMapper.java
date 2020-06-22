package com.example.demo.dao;

import com.example.demo.entity.Permission;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/13 19:10
 */
public interface PermissionMapper {
    List<Permission> findPremissionByName(String username);
}
