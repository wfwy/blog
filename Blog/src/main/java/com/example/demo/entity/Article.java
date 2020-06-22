package com.example.demo.entity;

import org.apache.ibatis.type.Alias;

import java.sql.Timestamp;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/5 19:32
 */
@Alias("article")
public class Article {
    int id;
    String article_type;
    String article_title;
    String article_content_md;
    String article_content_html;
    String article_abstract;
    String article_cover;
    int hits;
    Timestamp creat_time;
    Timestamp update_time;
    String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getArticle_type() {
        return article_type;
    }

    public void setArticle_type(String article_type) {
        this.article_type = article_type;
    }

    public String getArticle_title() {
        return article_title;
    }

    public void setArticle_title(String article_title) {
        this.article_title = article_title;
    }

    public String getArticle_content_md() {
        return article_content_md;
    }

    public void setArticle_content_md(String article_content_md) {
        this.article_content_md = article_content_md;
    }

    public String getArticle_content_html() {
        return article_content_html;
    }

    public void setArticle_content_html(String article_content_html) {
        this.article_content_html = article_content_html;
    }
    public String getArticle_abstract() {
        return article_abstract;
    }

    public void setArticle_abstract(String article_abstract) {
        this.article_abstract = article_abstract;
    }

    public String getArticle_cover() {
        return article_cover;
    }

    public void setArticle_cover(String article_cover) {
        this.article_cover = article_cover;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public Timestamp getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Timestamp creat_time) {
        this.creat_time = creat_time;
    }

    public Timestamp getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Timestamp update_time) {
        this.update_time = update_time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
