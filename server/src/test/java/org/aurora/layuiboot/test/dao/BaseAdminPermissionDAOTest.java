package org.aurora.layuiboot.test.dao;

import org.aurora.layuiboot.bootstrap.BootStrap;
import org.aurora.layuiboot.dao.BaseAdminPermissionDAO;
import org.aurora.layuiboot.dao.BaseAdminUserDAO;
import org.aurora.layuiboot.dto.PermissionDTO;
import org.aurora.layuiboot.po.BaseAdminUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author zhangjian
 * @date 2020/11/10 15:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = BootStrap.class)
public class BaseAdminPermissionDAOTest {

    @Resource
    private BaseAdminPermissionDAO baseAdminPermissionDAO;
    @Resource
    private BaseAdminUserDAO BaseAdminUserDAO;

    @Test
    public void testGetUserByName(){
        BaseAdminUser baseAdminUser = BaseAdminUserDAO.findByUserName("1");
        System.out.println(baseAdminUser);
    }

    @Test
    public void test(){
        List<PermissionDTO> list = baseAdminPermissionDAO.getParentPermissionList();
        for(PermissionDTO permissionDTO : list){
            System.out.println(permissionDTO.toString());
        }
    }
}
