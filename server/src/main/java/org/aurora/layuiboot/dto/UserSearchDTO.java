package org.aurora.layuiboot.dto;

import java.io.Serializable;

/**
 * @author zhangjian
 * @date 2020/11/10 15:35
 */
public class UserSearchDTO implements Serializable {
    private String sysUserName;

    private String userPhone;

    private String startTime;

    private String endTime;

    public String getSysUserName() {
        return sysUserName;
    }

    public void setSysUserName(String sysUserName) {
        this.sysUserName = sysUserName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "UserSearchDTO{" +
                "sysUserName='" + sysUserName + '\'' +
                ", userPhone='" + userPhone + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
