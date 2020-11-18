package org.aurora.layuiboot.service.impl;

import org.aurora.layuiboot.dao.BaseAdminUserDAO;
import org.aurora.layuiboot.dto.AdminUserDTO;
import org.aurora.layuiboot.dto.UserSearchDTO;
import org.aurora.layuiboot.po.BaseAdminUser;
import org.aurora.layuiboot.response.PageDataResult;
import org.aurora.layuiboot.service.AdminUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjian
 * @date 2020/11/11 8:52
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private BaseAdminUserDAO baseAdminUserDAO;

    @Override
    public PageDataResult getUserList(UserSearchDTO userSearch, Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        List<AdminUserDTO> baseAdminUsers = baseAdminUserDAO.getUserList(userSearch);

        if(baseAdminUsers.size() != 0){
            pageDataResult.setList(baseAdminUsers);
            pageDataResult.setTotals(3);
        }

        return pageDataResult;
    }

    @Override
    public Map<String, Object> addUser(BaseAdminUser user) {
        Map<String,Object> data = new HashMap();
//        try {
//            BaseAdminUser old = baseAdminUserDAO.getUserByUserName(user.getSysUserName(),null);
//            if(old != null){
//                data.put("code",0);
//                data.put("msg","用户名已存在！");
//                logger.error("用户[新增]，结果=用户名已存在！");
//                return data;
//            }
//            String phone = user.getUserPhone();
//            if(phone.length() != 11){
//                data.put("code",0);
//                data.put("msg","手机号位数不对！");
//                logger.error("置用户[新增或更新]，结果=手机号位数不对！");
//                return data;
//            }
//            String username = user.getSysUserName();
//            if(user.getSysUserPwd() == null){
//                String password = DigestUtils.Md5(username,"123456");
//                user.setSysUserPwd(password);
//            }else{
//                String password = DigestUtils.Md5(username,user.getSysUserPwd());
//                user.setSysUserPwd(password);
//            }
//            user.setRegTime(DateUtils.getCurrentDate());
//            user.setUserStatus(1);
//            int result = baseAdminUserDAO.insert(user);
//            if(result == 0){
//                data.put("code",0);
//                data.put("msg","新增失败！");
//                logger.error("用户[新增]，结果=新增失败！");
//                return data;
//            }
//            data.put("code",1);
//            data.put("msg","新增成功！");
//            logger.info("用户[新增]，结果=新增成功！");
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("用户[新增]异常！", e);
//            return data;
//        }
        return data;
    }

    @Override
    public Map<String, Object> updateUser(BaseAdminUser user) {
        Map<String,Object> data = new HashMap();
//        Long id = user.getId();
//        BaseAdminUser old = baseAdminUserDAO.getUserByUserName(user.getSysUserName(),id);
//        if(old != null){
//            data.put("code",0);
//            data.put("msg","用户名已存在！");
//            logger.error("用户[更新]，结果=用户名已存在！");
//            return data;
//        }
//        String username = user.getSysUserName();
//        if(user.getSysUserPwd() != null){
//            String password = DigestUtils.Md5(username,user.getSysUserPwd());
//            user.setSysUserPwd(password);
//        }
//
//        int result = baseAdminUserDAO.updateUser(user);
//        if(result == 0){
//            data.put("code",0);
//            data.put("msg","更新失败！");
//            logger.error("用户[更新]，结果=更新失败！");
//            return data;
//        }
//        data.put("code",1);
//        data.put("msg","更新成功！");
//        logger.info("用户[更新]，结果=更新成功！");
        return data;
    }

    @Override
    public BaseAdminUser getUserById(Integer id) {
        return null;
    }

    @Override
    public BaseAdminUser findByUserName(String userName) {
        return baseAdminUserDAO.findByUserName(userName);
    }

    @Override
    public int updatePwd(String userName, String password) {
//        password = DigestUtils.Md5(userName,password);
        return baseAdminUserDAO.updatePwd(userName,password);
    }

    @Override
    public Map<String, Object> delUser(Integer id, Integer status) {
        Map<String, Object> data = new HashMap<>();
        try {
            // 删除用户
            int result = baseAdminUserDAO.updateUserStatus(id,status);
            if(result == 0){
                data.put("code",0);
                data.put("msg","删除用户失败");
                logger.error("删除用户失败");
                return data;
            }
            data.put("code",1);
            data.put("msg","删除用户成功");
            logger.info("删除用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除用户异常！", e);
        }
        return data;
    }

    @Override
    public Map<String, Object> recoverUser(Integer id, Integer status) {
        Map<String, Object> data = new HashMap<>();
        try {
            int result = baseAdminUserDAO.updateUserStatus(id,status);
            if(result == 0){
                data.put("code",0);
                data.put("msg","恢复用户失败");
            }
            data.put("code",1);
            data.put("msg","恢复用户成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("恢复用户异常！", e);
        }
        return data;
    }
}
