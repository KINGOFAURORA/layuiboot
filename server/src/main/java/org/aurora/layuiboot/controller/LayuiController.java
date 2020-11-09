package org.aurora.layuiboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author zhangjian
 * @date 2020/11/9 10:15
 */
@Controller
@RequestMapping("/layui")
public class LayuiController {
    @RequestMapping("/index")
    public String index() {
        return "index.html";
    }
}
