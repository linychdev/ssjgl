package com.ustb.ssjgl.main.dao.bean;

import java.util.Date;

public class TLoginRecord {
    /** ���� */
    private String cId;

    /** �û�id */
    private String cUserId;

    /** �û��� */
    private String cUserName;

    /** �ͻ���ip */
    private String cClientIp;

    /** ��¼���� */
    private Date dLoginDate;

    /** ��¼ʱ�� */
    private Date dLoginTime;

    /** �ǳ�ʱ�� */
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