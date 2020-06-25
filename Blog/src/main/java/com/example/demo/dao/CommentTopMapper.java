package com.example.demo.dao;

import com.example.demo.entity.CommentTop;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/25 15:59
 */
public interface CommentTopMapper {
    public List<CommentTop> selectAll(int uid,int aid);
    public void insert(CommentTop commentTop);
    public void update(CommentTop commentTop);
}
