package org.aurora.layuiboot.service.impl;

import org.aurora.layuiboot.dao.BaseAdminPermissionDAO;
import org.aurora.layuiboot.dao.BaseAdminRoleDAO;
import org.aurora.layuiboot.po.BaseAdminPermission;
import org.aurora.layuiboot.po.BaseAdminRole;
import org.aurora.layuiboot.response.PageDataResult;
import org.aurora.layuiboot.service.AdminRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * @author zhangjian
 * @date 2020/11/11 8:44
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private BaseAdminRoleDAO baseAdminRoleDAO;

    @Resource
    private BaseAdminPermissionDAO baseAdminPermissionDAO;

    @Override
    public PageDataResult getRoleList(Integer pageNum, Integer pageSize) {
        PageDataResult pageDataResult = new PageDataResult();
        List<BaseAdminRole> roles = baseAdminRoleDAO.getRoleList();

//        List<AdminRoleDTO> roleList = new ArrayList<>();
//        for(BaseAdminRole r:roles){
//            AdminRoleDTO roleDTO =  new AdminRoleDTO();
//
//            String permissions = r.getPermissions();
//            BeanUtils.copyProperties(r,roleDTO);
//            roleDTO.setPermissionIds(permissions);
//
//            if(!StringUtils.isEmpty(permissions)){
//                String[] ids = permissions.split(",");
//                List<String> p = new ArrayList <>();
//                for(String id: ids){
//                    BaseAdminPermission baseAdminPermission = this.baseAdminPermission.selectByPrimaryKey(id);
//                    String name = baseAdminPermission.getName();
//                    p.add(name);
//                }
//                roleDTO.setPermissions(p.toString());
//            }
//            roleList.add(roleDTO);
//        }
//
//        PageHelper.startPage(pageNum, pageSize);
//
//        if(roleList.size() != 0){
//            PageInfo<AdminRoleDTO> pageInfo = new PageInfo<>(roleList);
//            pageDataResult.setList(roleList);
//            pageDataResult.setTotals((int) pageInfo.getTotal());
//        }
        return pageDataResult;
    }

    @Override
    public List<BaseAdminRole> getRoles() {
        return baseAdminRoleDAO.getRoleList();
    }

    @Override
    public BaseAdminRole findRoleById(Integer id) {
        return null;
    }

    @Override
    public Map<String, Object> updateRole(BaseAdminRole role) {
        Map<String,Object> data = new HashMap();
//        try{
//            role.setUpdateTime(DateUtils.getCurrentDate());
//            int result = baseAdminRoleDAO.updateRole(role);
//            if(result == 0){
//                data.put("code",0);
//                data.put("msg","更新失败！");
//                logger.error("角色[更新]，结果=更新失败！");
//                return data;
//            }
//            data.put("code",1);
//            data.put("msg","更新成功！");
//            logger.info("角色[更新]，结果=更新成功！");
//        }catch (Exception e) {
//            e.printStackTrace();
//            logger.error("角色[更新]异常！", e);
//            return data;
//        }
        return data;
    }

    @Override
    public Map<String, Object> delRole(Integer id, Integer status) {
        Map<String, Object> data = new HashMap<>();
        try {
            int result = baseAdminRoleDAO.updateRoleStatus(id,status);
            if(result == 0){
                data.put("code",0);
                data.put("msg","删除角色失败");
            }
            data.put("code",1);
            data.put("msg","删除角色成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("删除角色异常！", e);
        }
        return data;
    }

    @Override
    public Map<String, Object> recoverRole(Integer id, Integer status) {
        Map<String, Object> data = new HashMap<>();
        try {
            int result = baseAdminRoleDAO.updateRoleStatus(id,status);
            if(result == 0){
                data.put("code",0);
                data.put("msg","恢复角色失败");
            }
            data.put("code",1);
            data.put("msg","恢复角色成功");
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("恢复角色异常！", e);
        }
        return data;
    }

    @Override
    public Map<String, Object> addRole(BaseAdminRole role) {
        Map<String,Object> data = new HashMap();
//        try {
//            role.setCreateTime(new Date());
//            role.setUpdateTime(new Date());
//            role.setRoleStatus(1);
//            int result = baseAdminRoleDAO.insert(role);
//            if(result == 0){
//                data.put("code",0);
//                data.put("msg","新增角色失败");
//                logger.error("新增角色失败");
//                return data;
//            }
//            data.put("code",1);
//            data.put("msg","新增角色成功");
//        } catch (Exception e) {
//            e.printStackTrace();
//            logger.error("添加角色并授权！异常！", e);
//        }
        return data;
    }
}
