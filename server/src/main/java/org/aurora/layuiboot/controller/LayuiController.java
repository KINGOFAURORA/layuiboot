package org.aurora.layuiboot.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 访问指定页面的controller
 *
 * @author zhangjian
 * @date 2020/11/9 10:15
 */
@Controller
public class LayuiController {
    private final Logger logger = LoggerFactory.getLogger(LayuiController.class);

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("logout")
    public String logout() {
        logger.info("退出系统");
        Subject subject = SecurityUtils.getSubject();
        // shiro底层删除session的会话信息
        subject.logout();
        return "redirect:login";
    }
}
