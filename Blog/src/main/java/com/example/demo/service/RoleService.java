package com.example.demo.service;

import com.example.demo.dao.RoleMapper;
import com.example.demo.entity.Role;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/13 19:23
 */
@Service
public class RoleService {
    @Resource
    private RoleMapper roleMapper;
    public List<Role> findRolebyName(String username){
        return roleMapper.findRolebyName(username);
    }
}
