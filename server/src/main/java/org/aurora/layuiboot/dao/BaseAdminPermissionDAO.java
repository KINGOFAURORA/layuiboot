package org.aurora.layuiboot.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.aurora.layuiboot.dto.PermissionDTO;
import org.aurora.layuiboot.po.BaseAdminPermission;

import java.util.List;

/**
 * @author zhangjian
 * @date 2020/11/10 14:59
 */
@Mapper
public interface BaseAdminPermissionDAO {
    /**
     * 获取权限列表
     * @return
     */
    List<PermissionDTO> getPermissionList();

    /**
     * 获取父权限列表
     * @return
     */
    List<PermissionDTO> getParentPermissionList();

    /**
     * 更新权限信息
     * @param permission
     * @return
     */
    int updatePermission(BaseAdminPermission permission);

    /**
     * 根据父菜单ID查询权限列表
     * @param pid
     * @return
     */
    List<PermissionDTO> getPermissionListByPid(@Param("pid") Integer pid);
}
