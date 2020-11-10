package org.aurora.layuiboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.aurora.layuiboot.po.BaseAdminUser;
import org.aurora.layuiboot.request.LoginRequest;
import org.aurora.layuiboot.response.LoginResponse;
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

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

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
        subject.login(token);
        // 登录成功
        BaseAdminUser user = (BaseAdminUser) subject.getPrincipal();
        response.setCode(0);
        response.setMessage("登录成功");
        response.setUrl("/index");
        return response;
    }
}
