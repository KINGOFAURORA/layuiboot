package org.aurora.layuiboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.aurora.layuiboot.po.BaseAdminRole;

import java.util.List;

/**
 * @author zhangjian
 * @date 2020/11/10 15:33
 */
@Mapper
public interface BaseAdminRoleDAO {
    /**
     * 获取所有角色列表（包括无效）
     *
     * @return
     */
    List<BaseAdminRole> getRoleList();

    /**
     * 获取所有有效角色列表
     *
     * @return
     */
    List<BaseAdminRole> getRoles();

    /**
     * 更新角色状态
     *
     * @param role
     * @return
     */
    int updateRole(BaseAdminRole role);

    /**
     * 更新角色
     *
     * @param id
     * @param roleStatus
     * @return
     */
    int updateRoleStatus(@Param("id") Integer id, @Param("roleStatus") Integer roleStatus);
}
