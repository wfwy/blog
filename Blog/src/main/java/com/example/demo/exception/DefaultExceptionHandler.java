package com.example.demo.exception;

import com.example.demo.result.Result;
import com.example.demo.result.ResultFactory;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthenticatedException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/13 17:56
 */
@ControllerAdvice
public class DefaultExceptionHandler {
    @ExceptionHandler({ UnauthenticatedException.class, AuthenticationException.class })
    @ResponseBody
    public Result handleAuthenticationException(UnauthenticatedException e) {
        String message = "认证失败";
        return ResultFactory.buildFailResult(message);
    }
    @ExceptionHandler({ UnauthorizedException.class, AuthorizationException.class })
    @ResponseBody
    public Result handleAuthorizationException(UnauthorizedException e) {
        String message = "没有权限";
        return ResultFactory.buildFailResult(message);
    }

}
