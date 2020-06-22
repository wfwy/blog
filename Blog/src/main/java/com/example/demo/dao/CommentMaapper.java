package com.example.demo.dao;

import com.example.demo.entity.Comment;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/21 16:35
 */
public interface CommentMaapper {
    public void insertComment(Comment comment);
    public List<Comment> listComment(int aid);
}
