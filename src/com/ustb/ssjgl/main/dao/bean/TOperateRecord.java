package com.ustb.ssjgl.main.dao.bean;

import java.util.Date;

public class TOperateRecord {
    /** ���� */
    private String cId;

    /** �û�id */
    private String cUserId;

    /** �û��� */
    private String cUserName;

    /** �ͻ���ip */
    private String cClientIp;

    /** �������� */
    private Integer nOperateType;

    /** �������� */
    private Date dOperateDate;

    /** ����ʱ�� */
    private Date dOperateTime;

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

    public Integer getnOperateType() {
        return nOperateType;
    }

    public void setnOperateType(Integer nOperateType) {
        this.nOperateType = nOperateType;
    }

    public Date getdOperateDate() {
        return dOperateDate;
    }

    public void setdOperateDate(Date dOperateDate) {
        this.dOperateDate = dOperateDate;
    }

    public Date getdOperateTime() {
        return dOperateTime;
    }

    public void setdOperateTime(Date dOperateTime) {
        this.dOperateTime = dOperateTime;
    }
}