package com.ustb.ssjgl.main.dao.bean;

import java.util.Date;

public class TSearchRecord {
    /** 主键 */
    private String cId;

    /** 用户id */
    private String cUserId;

    /** 用户名 */
    private String cUserName;

    /** 客户端ip */
    private String cClientIp;

    /** 搜索内容 */
    private String cSearchText;

    /** 是否为有效搜索 */
    private Integer nValidSearch;

    /** 返回数据条数 */
    private Integer nResultNum;

    /** 搜索日期 */
    private Date dSearchDate;

    /** 搜索时间 */
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