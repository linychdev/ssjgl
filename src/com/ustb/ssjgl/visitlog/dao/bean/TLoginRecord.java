package com.ustb.ssjgl.visitlog.dao.bean;

import java.util.Date;

public class TLoginRecord {
    /** 主键 */
    private String cId;

    /** 用户id */
    private String cUserId;

    /** 用户名 */
    private String cUserName;

    /** 客户端ip */
    private String cClientIp;

    /** 登录日期 */
    private Date dLoginDate;

    /** 登录时间 */
    private Date dLoginTime;

    /** 登出时间 */
    private Date dLogoutTime;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcUserId() {
        return cUserId;
    }

    public void setcUserId(String cUserId) {
        this.cUserId = cUserId == null ? null : cUserId.trim();
    }

    public String getcUserName() {
        return cUserName;
    }

    public void setcUserName(String cUserName) {
        this.cUserName = cUserName == null ? null : cUserName.trim();
    }

    public String getcClientIp() {
        return cClientIp;
    }

    public void setcClientIp(String cClientIp) {
        this.cClientIp = cClientIp == null ? null : cClientIp.trim();
    }

    public Date getdLoginDate() {
        return dLoginDate;
    }

    public void setdLoginDate(Date dLoginDate) {
        this.dLoginDate = dLoginDate;
    }

    public Date getdLoginTime() {
        return dLoginTime;
    }

    public void setdLoginTime(Date dLoginTime) {
        this.dLoginTime = dLoginTime;
    }

    public Date getdLogoutTime() {
        return dLogoutTime;
    }

    public void setdLogoutTime(Date dLogoutTime) {
        this.dLogoutTime = dLogoutTime;
    }
}