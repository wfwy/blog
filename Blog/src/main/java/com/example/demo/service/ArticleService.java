package com.example.demo.service;

import com.example.demo.dao.ArticleMapper;
import com.example.demo.dao.RoleMapper;
import com.example.demo.entity.Article;
import com.example.demo.entity.Role;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/5 19:58
 */
@Service
public class ArticleService {
    @Resource
    private ArticleMapper articleMapper;
    @Resource
    private RoleMapper roleMapper;

    /**
     * 通过id查找
     * @param id
     * @return
     */
    public Article selArticle(int id){
        return articleMapper.selArticle(id);
    }
    /**
     * 数据库分页
     * @return
     */
    public List<Article> listArticle(String selArticle) {
        return articleMapper.listArticle(selArticle);
    }
    /**
     *  listArticle分页
     * @param pageSize
     * @param pageNum
     * @return
     */
    public PageInfo findPage(int pageSize,int pageNum,String selArticle){
        PageHelper.startPage(pageNum,pageSize);
        List<Article> list = articleMapper.listArticle(selArticle);
        PageInfo<Article> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }
    /**
     * 查找最新三条
     * @return
     */
    public List<Article> listNewArticle() {
        return articleMapper.listNewArticle();
    }
    /**
     * 通过姓名查找
     * @param username
     * @return
     */
    public List<Article> listByName(String username,String article_type) {
        return articleMapper.listByName(username,article_type);
    }
    /**
     * listByName分页
     * @param pageSize
     * @param pageNum
     * @return
     */
    public PageInfo findPagebyname(int pageSize,int pageNum,String article_type){
        PageHelper.startPage(pageNum,pageSize);
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        List<Article> list = articleMapper.listByName(username,article_type);
        PageInfo<Article> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    /**
     * 点击量
     * @param article
     */
    public void updateHits(Article article){
        articleMapper.updateHits(article);
    }
    /**
     * 后台
     * @return
     */
    public List<Article> listArticles() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        String role = null;
        List<Role> roles= roleMapper.findRolebyName(username);
        for (Role roles1 : roles) {
            if (roles1.getName().equals("admin")){
                role = roles1.getName();
            }else {
                role = null;
            }
        }
        return articleMapper.listArticles(username,role);
    }
    /**
     * 修改
     * @param article
     */
    public void updateById(Article article) {
        articleMapper.updateById(article);
    }
    /**
     * 删除
     * @param id
     */
    public void delById(int id) {
        articleMapper.delById(id);
    }
    /**
     * 博客添加
     * @param article
     */
    public void addArticle(Article article){
        articleMapper.addArticle(article);
    }
    /**
     * 后台搜索框
     * @param article_type
     * @param article_title
     * @return
     */
    public List<Article> selectArticle(String article_type,String article_title){
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        String role = null;
        List<Role> roles= roleMapper.findRolebyName(username);
        for (Role roles1 : roles) {
            if (roles1.getName().equals("admin")){
                role = roles1.getName();
            }else {
                role = null;
            }
        }
        return articleMapper.selectArticle(article_type,article_title,username,role);
    }
}
