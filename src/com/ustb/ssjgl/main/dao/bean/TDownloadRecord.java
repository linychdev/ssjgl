package com.ustb.ssjgl.main.dao.bean;

import java.util.Date;

public class TDownloadRecord {
    /** ���� */
    private String cId;

    /** �û�id */
    private String cUserId;

    /** �û��� */
    private String cUserName;

    /** �ͻ���ip */
    private String cClientIp;

    /** �������� */
    private String cDownloadFileId;

    /** �����ļ��� */
    private String cDownloadFileName;

    /** �������� */
    private Date dDownloadDate;

    /** ����ʱ�� */
    private Date dDownloadTime;

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

    public String getcDownloadFileId() {
        return cDownloadFileId;
    }

    public void setcDownloadFileId(String cDownloadFileId) {
        this.cDownloadFileId = cDownloadFileId == null ? null : cDownloadFileId.trim();
    }

    public String getcDownloadFileName() {
        return cDownloadFileName;
    }

    public void setcDownloadFileName(String cDownloadFileName) {
        this.cDownloadFileName = cDownloadFileName == null ? null : cDownloadFileName.trim();
    }

    public Date getdDownloadDate() {
        return dDownloadDate;
    }

    public void setdDownloadDate(Date dDownloadDate) {
        this.dDownloadDate = dDownloadDate;
    }

    public Date getdDownloadTime() {
        return dDownloadTime;
    }

    public void setdDownloadTime(Date dDownloadTime) {
        this.dDownloadTime = dDownloadTime;
    }
}