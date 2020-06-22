package com.example.demo.entity;

import java.sql.Timestamp;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/17 14:22
 */
public class Notification {
    private int id;
    private String title;
    private String message;
    private Timestamp creat_time;
    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getCreat_time() {
        return creat_time;
    }

    public void setCreat_time(Timestamp creat_time) {
        this.creat_time = creat_time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
