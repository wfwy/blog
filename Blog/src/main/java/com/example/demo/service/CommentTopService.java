package com.example.demo.service;

import com.example.demo.dao.CommentTopMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.CommentTop;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/25 18:02
 */
@Service
public class CommentTopService {
    @Resource
    private CommentTopMapper commentTopMapper;
    @Resource
    private UserMapper userMapper;

    public void insert(CommentTop commentTop){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int uid = userMapper.findByName(username).getId();
        commentTop.setUid(uid);
        commentTopMapper.insert(commentTop);
    }
    public void update(CommentTop commentTop){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        int uid = userMapper.findByName(username).getId();
        commentTop.setUid(uid);
        commentTopMapper.update(commentTop);
    }
}
