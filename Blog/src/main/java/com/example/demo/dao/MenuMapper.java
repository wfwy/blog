package com.example.demo.dao;

import com.example.demo.entity.Menu;

import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/14 11:15
 */
public interface MenuMapper {
    List<Menu> findMenu(String username);
}
