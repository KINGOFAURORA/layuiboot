package org.aurora.layuiboot.controller;

import org.aurora.layuiboot.dto.UserDTO;
import org.aurora.layuiboot.response.ListResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangjian
 * @date 2020/11/9 16:08
 */
@Controller
public class ListController {

    @ResponseBody
    @RequestMapping("user/list")
    public ListResponse getUserList(){
        List<UserDTO> userDTOList = new ArrayList<>();
        UserDTO user1 = new UserDTO();
        user1.setId(111L);
        user1.setUserName("aaaa");
        user1.setAge(20);
        userDTOList.add(user1);

        UserDTO user2 = new UserDTO();
        user2.setId(222L);
        user2.setUserName("bbbb");
        user2.setAge(30);
        userDTOList.add(user2);

        ListResponse response = ListResponse.getSuccessResponse();
        response.setUserDTOList(userDTOList);
        return response;
    }
}
