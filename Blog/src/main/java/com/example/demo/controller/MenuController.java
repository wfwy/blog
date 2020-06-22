package com.example.demo.controller;

import com.example.demo.entity.Menu;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.MenuService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/14 12:26
 */
@Controller
@ResponseBody
public class MenuController {
    @Resource
    private MenuService menuService;

    /**
     * 后台菜单
     * @return
     */
    @GetMapping(value = "/api/admin/menu")
    public Result finMenu() {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        System.out.println(SecurityUtils.getSubject().getPrincipal());
        List<Menu> menu =menuService.findMenu(username);
        if (menu != null){
            return ResultFactory.buildSuccessResult(menu);
        }else {
            return ResultFactory.buildFailResult("失败");
        }

    }
}
