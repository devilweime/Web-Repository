package com.pms.mailbag.dao.model;

import java.util.Date;

public class CUserLoginRecord {
    private Integer userLoginRecordId;

    private String userId;

    private String loginAddress;

    private String loginStatus;

    private Date loginTime;

    private Date createTime;

    private String createBy;

    private Date updateTime;

    private String updateBy;

    public Integer getUserLoginRecordId() {
        return userLoginRecordId;
    }

    public void setUserLoginRecordId(Integer userLoginRecordId) {
        this.userLoginRecordId = userLoginRecordId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getLoginAddress() {
        return loginAddress;
    }

    public void setLoginAddress(String loginAddress) {
        this.loginAddress = loginAddress == null ? null : loginAddress.trim();
    }

    public String getLoginStatus() {
        return loginStatus;
    }

    public void setLoginStatus(String loginStatus) {
        this.loginStatus = loginStatus == null ? null : loginStatus.trim();
    }

    public Date getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Date loginTime) {
        this.loginTime = loginTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy == null ? null : createBy.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy == null ? null : updateBy.trim();
    }
}