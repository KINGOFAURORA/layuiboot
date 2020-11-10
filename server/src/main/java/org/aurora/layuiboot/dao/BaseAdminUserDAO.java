package org.aurora.layuiboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.aurora.layuiboot.dto.AdminUserDTO;
import org.aurora.layuiboot.dto.UserSearchDTO;
import org.aurora.layuiboot.po.BaseAdminUser;

import java.util.List;

/**
 * @author zhangjian
 * @date 2020/11/10 15:34
 */
@Mapper
public interface BaseAdminUserDAO {
    /**
     * 获取用户列表
     *
     * @param userSearchDTO
     * @return
     */
    List<AdminUserDTO> getUserList(UserSearchDTO userSearchDTO);

    /**
     * 根据用户名和ID获取用户
     *
     * @param sysUserName
     * @param id
     * @return
     */
    BaseAdminUser getUserByUserName(@Param("sysUserName") String sysUserName, @Param("id") Integer id);

    /**
     * 根据ID更新用户状态
     *
     * @param id
     * @param status
     * @return
     */
    int updateUserStatus(@Param("id") Integer id, @Param("status") Integer status);

    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    int updateUser(BaseAdminUser user);

    /**
     * 根据用户名查询用户
     *
     * @param userName
     * @return
     */
    BaseAdminUser findByUserName(@Param("userName") String userName);

    /**
     * 更新密码
     *
     * @param userName
     * @param password
     * @return
     */
    int updatePwd(@Param("userName") String userName, @Param("password") String password);
}
