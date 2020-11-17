package org.aurora.layuiboot.service;

import org.aurora.layuiboot.po.BaseAdminRole;
import org.aurora.layuiboot.response.PageDataResult;

import java.util.List;
import java.util.Map;

/**
 * @author zhangjian
 * @date 2020/11/10 17:16
 */
public interface AdminRoleService {
    /**
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageDataResult getRoleList(Integer pageNum, Integer pageSize);

    /**
     *
     * @return
     */
    List<BaseAdminRole> getRoles();

    /**
     *
     * @param id
     * @return
     */
    BaseAdminRole findRoleById(Integer id);

    /**
     *
     * @param role
     * @return
     */
    Map<String,Object> updateRole(BaseAdminRole role);

    /**
     *
     * @param id
     * @param status
     * @return
     */
    Map<String,Object> delRole(Integer id,Integer status);

    /**
     *
     * @param id
     * @param status
     * @return
     */
    Map<String,Object> recoverRole(Integer id,Integer status);

    /**
     *
     * @param role
     * @return
     */
    Map<String,Object> addRole(BaseAdminRole role);
}
