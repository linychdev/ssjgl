package com.ustb.ssjgl.main.dao.bean;

import java.util.Date;

public class TSearchRecord {
    /** ���� */
    private String cId;

    /** �û�id */
    private String cUserId;

    /** �û��� */
    private String cUserName;

    /** �ͻ���ip */
    private String cClientIp;

    /** �������� */
    private String cSearchText;

    /** �Ƿ�Ϊ��Ч���� */
    private Integer nValidSearch;

    /** ������������ */
    private Integer nResultNum;

    /** �������� */
    private Date dSearchDate;

    /** ����ʱ�� */
    private Date dSearchTime;

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

    public String getcSearchText() {
        return cSearchText;
    }

    public void setcSearchText(String cSearchText) {
        this.cSearchText = cSearchText == null ? null : cSearchText.trim();
    }

    public Integer getnValidSearch() {
        return nValidSearch;
    }

    public void setnValidSearch(Integer nValidSearch) {
        this.nValidSearch = nValidSearch;
    }

    public Integer getnResultNum() {
        return nResultNum;
    }

    public void setnResultNum(Integer nResultNum) {
        this.nResultNum = nResultNum;
    }

    public Date getdSearchDate() {
        return dSearchDate;
    }

    public void setdSearchDate(Date dSearchDate) {
        this.dSearchDate = dSearchDate;
    }

    public Date getdSearchTime() {
        return dSearchTime;
    }

    public void setdSearchTime(Date dSearchTime) {
        this.dSearchTime = dSearchTime;
    }
}