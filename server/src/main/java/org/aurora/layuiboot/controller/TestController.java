package org.aurora.layuiboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangjian
 * @date 2020/11/9 10:00
 */
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("test")
    public String test(){
        return "ok";
    }
}
