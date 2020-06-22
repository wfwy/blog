package com.example.demo.entity;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/13 19:05
 */
public class Role {
    private int id;
    private String name;
    private String name_zh;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName_zh() {
        return name_zh;
    }

    public void setName_zh(String name_zh) {
        this.name_zh = name_zh;
    }
}
