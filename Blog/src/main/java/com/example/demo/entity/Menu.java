package com.example.demo.entity;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/14 11:12
 */
public class Menu {
    private int id;
    private String path;
    private String name;
    private String name_zh;
    private String icon;
    private String component;
    private int parent_id;
    List<Menu> Children;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getComponent() {
        return component;
    }

    public void setComponent(String component) {
        this.component = component;
    }

    public int getParent_id() {
        return parent_id;
    }

    public void setParent_id(int parent_id) {
        this.parent_id = parent_id;
    }

    public List<Menu> getChildren() {
        return Children;
    }

    public void setChildren(List<Menu> children) {
        Children = children;
    }

}
