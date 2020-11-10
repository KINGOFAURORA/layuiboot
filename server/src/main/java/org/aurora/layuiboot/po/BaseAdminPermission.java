package org.aurora.layuiboot.po;

import java.io.Serializable;
import java.util.Date;

/**
 * @author zhangjian
 */
public class BaseAdminPermission implements Serializable {
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父菜单id
     */
    private Integer pid;

    /**
     * 描述
     */
    private String descpt;

    /**
     * 菜单url
     */
    private String url;

    /**
     * 添加时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 删除标志（0:删除 1：存在）
     */
    private Integer delFlag;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getDescpt() {
        return descpt;
    }

    public void setDescpt(String descpt) {
        this.descpt = descpt;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(Integer delFlag) {
        this.delFlag = delFlag;
    }

    @Override
    public String toString() {
        return "BaseAdminPermission{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pid=" + pid +
                ", descpt='" + descpt + '\'' +
                ", url='" + url + '\'' +
                ", createTime='" + createTime + '\'' +
                ", updateTime='" + updateTime + '\'' +
                ", delFlag=" + delFlag +
                '}';
    }
}