package org.aurora.layuiboot.controller;

import org.aurora.layuiboot.request.LoginRequest;
import org.aurora.layuiboot.response.LoginResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
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
        System.out.println("login ----- >" + request.getUserName());
        System.out.println("login ----- >" + request.getPassword());
        response.setCode(0);
        response.setMessage("登录成功");
        response.setUrl("/index");
        return response;
    }
}
