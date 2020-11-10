package org.aurora.layuiboot.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangjian
 */
public class BaseAdminUser implements Serializable {
    /**
     * ID
     */
    private Long id;

    /**
     * 系统用户名称
     */
    private String sysUserName;

    /**
     * 系统用户密码
     */
    private String sysUserPwd;

    /**
     * 角色
     */
    private Integer roleId;

    /**
     * 手机号
     */
    private String userPhone;

    /**
     * 登记时间
     */
    private Date regTime;

    /**
     * 状态（0：无效；1：有效）
     */
    private Integer userStatus;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public Date getRegTime() {
        return regTime;
    }

    public void setRegTime(Date regTime) {
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
        return "BaseAdminUser{" +
                "id=" + id +
                ", sysUserName='" + sysUserName + '\'' +
                ", sysUserPwd='" + sysUserPwd + '\'' +
                ", roleId=" + roleId +
                ", userPhone='" + userPhone + '\'' +
                ", regTime='" + regTime + '\'' +
                ", userStatus=" + userStatus +
                '}';
    }
}