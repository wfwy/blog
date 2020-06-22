package com.example.demo.realm;

import com.example.demo.entity.Permission;
import com.example.demo.entity.Role;
import com.example.demo.entity.User;
import com.example.demo.service.PermissionService;
import com.example.demo.service.RoleService;
import com.example.demo.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description: TODO(这里用一句话描述这个类的作用)
 * @Author Ningbo Fan
 * @Date 2020/6/13 15:41
 */
public class myRealm extends AuthorizingRealm {
    @Resource
    private UserService userService;
    @Resource
    private PermissionService permissionService;
    @Resource
    private RoleService roleService;
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken)
            throws AuthenticationException {
        System.out.println("shiro认证");
        UsernamePasswordToken UsernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username =UsernamePasswordToken.getPrincipal().toString();
        User user = userService.findByName(username);
        if (user != null){
            String passwordIndb = user.getPassword();
            String salt = user.getSalt();
            SimpleAuthenticationInfo simpleAuthenticationInfo
                    = new SimpleAuthenticationInfo(username,passwordIndb, ByteSource.Util.bytes(salt),getName());
            return simpleAuthenticationInfo;
        }else {
            return null;
        }
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("shiro授权");

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        String username = principalCollection.getPrimaryPrincipal().toString();
        // 调用业务层，查询角色
        List<Role> roles = roleService.findRolebyName(username);
        for (Role role : roles) {
            authorizationInfo.addRole(role.getName());
        }
        // 调用业务层，查询权限
        List<Permission> permissions = permissionService.findPremissionByName(username);
        for (Permission permission : permissions) {
            authorizationInfo.addStringPermission(permission.getUrl());
        }
        return authorizationInfo;

    }
}
