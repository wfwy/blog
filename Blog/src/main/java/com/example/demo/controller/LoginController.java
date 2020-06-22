package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import com.example.demo.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/13 14:23
 */
@Controller
@ResponseBody
public class LoginController {
    @Resource
    private UserService userService;

    /***
     * 登录
     * @param requ
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/api/login")
    public Result login(@RequestBody User requ) throws Exception {
        String username = requ.getUsername();
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username,requ.getPassword());
        usernamePasswordToken.setRememberMe(true);
        try {
            subject.login(usernamePasswordToken);
            return ResultFactory.buildSuccessResult(username);
        } catch (UnknownAccountException e) {
            String message = "用户名不存在";
            return ResultFactory.buildFailResult(message);
        }catch (AuthenticationException e) {
            String message = "账号密码错误";
            return ResultFactory.buildFailResult(message);
        }
    }

    /**
     * 注册
     * @param user
     * @return
     * @throws Exception
     */
    @PostMapping(value = "/api/register")
    public Result register(@RequestBody User user) throws Exception {
        String username = user.getUsername();
        String password = user.getPassword();
        user.setUsername(username);
        boolean exist = userService.isExist(username);
        if (exist) {
            String message = "用户名已被使用";
            return ResultFactory.buildFailResult(message);
        }else {
            // 生成盐,默认长度 16 位
            String salt = new SecureRandomNumberGenerator().nextBytes().toString();
            // 设置 hash 算法迭代次数
            int times = 2;
            // 得到 hash 后的密码
            String encodedPassword = new SimpleHash("md5", password, salt, times).toString();
            // 存储用户信息，包括 salt 与 hash 后的密码
            user.setSalt(salt);
            user.setPassword(encodedPassword);
            userService.addUser(user);
            return ResultFactory.buildSuccessResult(user);
        }
    }

    /**
     * shiro权限测试
     * @return
     * @throws Exception
     */
    @RequiresPermissions("/api/admin/ListUser")
    @GetMapping(value = "/api/admin/ListUser")
    public Result findAll() throws Exception{
        List<User> user =userService.findAll();
        if (user == null) {
            return ResultFactory.buildFailResult("查询失败");
        }else {
            return ResultFactory.buildSuccessResult(user);
        }
    }

    /**
     * 登录验证
     * @return
     */
    @GetMapping(value = "/api/authentication")
    public Result authentication(){
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()){
            String msg = "你没有登录，请登录后尝试！";
            return ResultFactory.buildFailResult(msg);
        }else {
            String msg = "欢迎来到后台";
            return ResultFactory.buildSuccessResult(msg);
        }
    }

    /**
     * 登出
     * @return
     */
    @GetMapping("api/logout")
    public Result logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        String message = "成功登出";
        return ResultFactory.buildSuccessResult(message);
    }
}
