package com.example.demo.service;

import com.example.demo.dao.CommentMaapper;
import com.example.demo.entity.Comment;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/21 16:44
 */
@Service
public class CommentService {
    @Resource
    private CommentMaapper commentMaapper;

    /**
     * 评论
     * @param comment
     */
    public void insertComment(Comment comment){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        comment.setUsername(username);
        commentMaapper.insertComment(comment);
    }

    /**
     * 章评
     * @param aid
     * @return
     */
    public List<Comment> listComment(int aid) {
        return commentMaapper.listComment(aid);
    }
}
