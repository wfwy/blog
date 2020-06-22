package com.example.demo.service;

import com.example.demo.dao.PermissionMapper;
import com.example.demo.entity.Permission;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/13 19:19
 */
@Service
public class PermissionService {
    @Resource
    private PermissionMapper permissionMapper;
    public List<Permission> findPremissionByName(String username){
        return permissionMapper.findPremissionByName(username);
    }
}
