package org.aurora.layuiboot.service;

import org.aurora.layuiboot.dto.UserSearchDTO;
import org.aurora.layuiboot.po.BaseAdminUser;
import org.aurora.layuiboot.response.PageDataResult;

import java.util.Map;

/**
 * @author zhangjian
 * @date 2020/11/10 17:16
 */
public interface AdminUserService {
    /**
     *
     * @param userSearch
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDataResult getUserList(UserSearchDTO userSearch, Integer pageNum, Integer pageSize);

    /**
     *
     * @param user
     * @return
     */
    Map<String,Object> addUser(BaseAdminUser user);

    /**
     *
     * @param user
     * @return
     */
    Map<String,Object> updateUser(BaseAdminUser user);

    /**
     *
     * @param id
     * @return
     */
    BaseAdminUser getUserById(Integer id);

    /**
     *
     * @param userName
     * @return
     */
    BaseAdminUser findByUserName(String userName);

    /**
     *
     * @param userName
     * @param password
     * @return
     */
    int updatePwd(String userName,String password);

    /**
     *
     * @param id
     * @param status
     * @return
     */
    Map<String, Object> delUser(Integer id,Integer status);

    /**
     *
     * @param id
     * @param status
     * @return
     */
    Map<String, Object> recoverUser(Integer id,Integer status);
}
