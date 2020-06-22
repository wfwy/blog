package com.example.demo.dao;

import com.example.demo.entity.Article;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/5 19:41
 */
@Mapper
public interface ArticleMapper {
    /**
     * 增
     * @param article
     */
    public void addArticle(Article article);
    /**
     * 查 by id
     * @param id
     * @return
     */
    public Article selArticle(int id);
    /**
     * 查找全部
     * @return
     */
    public List<Article> listArticle(String selArticle);
    /**
     * 最新三条
     * @return
     */
    public List<Article> listNewArticle();
    /**
     * 后台
     * @param username
     * @param role
     * @return
     */
    public List<Article> listArticles(String username,String role);
    /**
     * 通过名字
     * @param username
     * @return
     */
    public List<Article> listByName(String username,String article_type);
    /**
     * 修改
     * @param article
     */
    public void updateById(Article article);
    /**
     * 删除
     * @param id
     */
    public void delById(int id);
    /**
     * 查找
     * @param article_type
     * @param article_title
     * @return
     */
    public List<Article> selectArticle(String article_type,String article_title,String username,String role);

    /**
     * 点击量
     * @param article
     */
    public void updateHits(Article article);
}
