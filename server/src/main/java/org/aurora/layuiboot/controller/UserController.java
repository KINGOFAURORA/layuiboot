package org.aurora.layuiboot.controller;

import org.aurora.layuiboot.dto.UserSearchDTO;
import org.aurora.layuiboot.response.PageDataResult;
import org.aurora.layuiboot.service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author zhangjian
 * @date 2020/11/17 16:24
 */
@Controller
public class UserController {
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private AdminUserService adminUserService;

    @RequestMapping("/userManage")
    public String index() {
        return "user/userManage";
    }

    @RequestMapping(value = "user/getUserList", method = RequestMethod.POST)
    @ResponseBody
    public PageDataResult getUserList(@RequestParam("pageNum") Integer pageNum,
                                      @RequestParam("pageSize") Integer pageSize,/*@Valid PageRequest page,*/ UserSearchDTO userSearch) {
        /*logger.info("分页查询用户列表！搜索条件：userSearch：" + userSearch + ",pageNum:" + page.getPageNum()
                + ",每页记录数量pageSize:" + page.getPageSize());*/
        PageDataResult pdr = new PageDataResult();
        try {
            if(null == pageNum) {
                pageNum = 1;
            }
            if(null == pageSize) {
                pageSize = 10;
            }
            // 获取用户列表
            pdr = adminUserService.getUserList(userSearch, pageNum ,pageSize);
            logger.info("用户列表查询=pdr:" + pdr);

        } catch (Exception e) {
            e.printStackTrace();
            logger.error("用户列表查询异常！", e);
        }
        return pdr;
    }
}
