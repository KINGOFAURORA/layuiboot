package org.aurora.layuiboot.shiro;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.aurora.layuiboot.po.BaseAdminUser;
import org.aurora.layuiboot.service.AdminPermissionService;
import org.aurora.layuiboot.service.AdminRoleService;
import org.aurora.layuiboot.service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;

/**
 * @author zhangjian
 * @date 2020/11/10 16:17
 */
public class MyRealm extends AuthorizingRealm {
    private final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Resource
    private AdminUserService userService;

    @Resource
    private AdminRoleService roleService;

    @Resource
    private AdminPermissionService permissionService;

    public MyRealm() {
    }

    /**
     * 授权
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //授权
        logger.info("授予角色和权限");
        // 添加权限 和 角色信息
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        // 获取当前登陆用户
        /*Subject subject = SecurityUtils.getSubject();
        BaseAdminUser user = (BaseAdminUser) subject.getPrincipal();
        System.out.println(user);
        if (user.getSysUserName().equals("admin")) {
            // 超级管理员，添加所有角色、添加所有权限
            authorizationInfo.addRole("*");
            authorizationInfo.addStringPermission("*");
        } else {
            // 普通用户，查询用户的角色，根据角色查询权限
            Integer roleId = user.getRoleId();
            BaseAdminRole role = roleService.findRoleById(roleId);
            if (null != role ) {
                String permissions = role.getPermissions();
                String[] ids = permissions.split(",");
                for (String id : ids) {
                    authorizationInfo.addRole(role.getRoleName());
                    // 角色对应的权限数据
                    BaseAdminPermission perm = permissionService.getById(id);
                    if (null != perm ) {
                        // 授权角色下所有权限
                        authorizationInfo.addStringPermission(perm.getUrl());
                    }
                }
            }
        }*/
        return authorizationInfo;
    }

    /**
     * 认证
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //UsernamePasswordToken用于存放提交的登录信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        logger.info("用户登录认证：验证当前Subject时获取到token为：" + ReflectionToStringBuilder
                .toString(token, ToStringStyle.MULTI_LINE_STYLE));
        String username = token.getUsername();
        // 调用数据层
        BaseAdminUser sysUser = userService.findByUserName(username);
        logger.debug("用户登录认证！用户信息user：" + sysUser);
        if (sysUser == null) {
            // 用户不存在
            return null;
        }
        // 返回密码
        return new SimpleAuthenticationInfo(sysUser, sysUser.getSysUserPwd(), ByteSource.Util.bytes(username), getName());
    }
}
