package com.example.demo.service;

import com.example.demo.dao.CommentMaapper;
import com.example.demo.dao.CommentTopMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.Comment;
import com.example.demo.entity.CommentTop;
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
    @Resource
    private UserMapper userMapper;
    @Resource
    private CommentTopMapper commentTopMapper;
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
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        if (username != null){
            int uid = userMapper.findByName(username).getId();
            List<CommentTop> commentTops = commentTopMapper.selectAll(uid,aid);
            List<Comment> comments = commentMaapper.listComment(aid);
            for (Comment comment:comments){
                List<Comment> children = comment.getChildren();
                for (Comment childrens:children){
                    for (CommentTop commentTop:commentTops){
                        if (childrens.getId()==commentTop.getCid()){
                            childrens.setState(commentTop.getState());
                        }
                    }
                }
                for (CommentTop commentTop:commentTops){
                    if (comment.getId()==commentTop.getCid()){
                        comment.setState(commentTop.getState());
                    }
                }
            }
            return comments;
        }else {
            List<Comment> comments = commentMaapper.listComment(aid);
            return comments;
        }

    }
}
