package org.aurora.layuiboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.DisabledAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.aurora.layuiboot.po.BaseAdminUser;
import org.aurora.layuiboot.request.LoginRequest;
import org.aurora.layuiboot.response.LoginResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangjian
 * @date 2020/11/10 8:59
 */
@Controller
public class LoginController {
    private final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @ResponseBody
    @RequestMapping(value = "/user/login", method = RequestMethod.POST)
    public LoginResponse doLogin(LoginRequest request){
        LoginResponse response = new LoginResponse();
        String userName = request.getUserName();
        String password = request.getPassword();
        System.out.println("login ----- >" + userName);
        System.out.println("login ----- >" + password);
        //获取token
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        // 使用 shiro 进行登录
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(token);
            // 登录成功
            BaseAdminUser user = (BaseAdminUser) subject.getPrincipal();
            response.setCode(0);
            response.setMessage("登录成功");
            response.setUrl("/index");
            logger.info(user.getSysUserName()+"登陆成功");
        } catch (UnknownAccountException e) {
            response.setCode(10);
            response.setMessage(userName+"账号不存在");
            logger.error(userName+"账号不存在");
        }catch (DisabledAccountException e){
            response.setCode(20);
            response.setMessage(userName+"账号异常");
            logger.error(userName+"账号异常");
        }
        catch (AuthenticationException e){
            response.setCode(30);
            response.setMessage(userName+"密码错误");
            logger.error(userName+"密码错误");
        }
        return response;
    }
}
