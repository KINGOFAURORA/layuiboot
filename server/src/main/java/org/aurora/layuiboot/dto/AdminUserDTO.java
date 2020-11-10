package org.aurora.layuiboot.dto;

import java.io.Serializable;

/**
 * @author zhangjian
 * @date 2020/11/10 15:34
 */
public class AdminUserDTO implements Serializable {
    private Integer id;

    private String sysUserName;

    private String sysUserPwd;

    private Integer roleId;

    private String roleName;

    private String userPhone;


    private String regTime;


    private Integer userStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public String getSysUserPwd() {
        return sysUserPwd;
    }

    public void setSysUserPwd(String sysUserPwd) {
        this.sysUserPwd = sysUserPwd;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    @Override
    public String toString() {
        return "AdminUserDTO{" +
                "id=" + id +
                ", sysUserName='" + sysUserName + '\'' +
                ", sysUserPwd='" + sysUserPwd + '\'' +
                ", roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", regTime='" + regTime + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}
