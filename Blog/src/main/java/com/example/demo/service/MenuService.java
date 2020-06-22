package com.example.demo.service;

import com.example.demo.dao.MenuMapper;
import com.example.demo.entity.Menu;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/14 12:29
 */
@Service
public class MenuService {
    @Resource
    private MenuMapper menuMapper;
    public List<Menu> findMenu(String username){
       List<Menu> menus = menuMapper.findMenu(username);
       return menus;
    }
}
