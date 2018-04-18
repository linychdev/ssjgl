package com.ustb.ssjgl.login.dao.bean;

import java.sql.Timestamp;

import com.ustb.ssjgl.common.MailConfigFile;
import com.ustb.ssjgl.common.utils.DateUtils;
import com.ustb.ssjgl.common.utils.UuidUtils;

public class TEmailRecord {
    private String cId;

    private String cEmail;

    private String cVerificationCode;

    private String cHtml;

    private Timestamp dSendTime;

    private Timestamp dOverdueTime;

    
    
    
    public TEmailRecord() {
        super();
        this.cId = UuidUtils.getUuid();
        this.dSendTime = DateUtils.getCurrentDate();
        this.dOverdueTime = DateUtils.addMinutes(this.dSendTime, MailConfigFile.failureTime);
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail == null ? null : cEmail.trim();
    }

    public String getcVerificationCode() {
        return cVerificationCode;
    }

    public void setcVerificationCode(String cVerificationCode) {
        this.cVerificationCode = cVerificationCode == null ? null : cVerificationCode.trim();
    }

    public String getcHtml() {
        return cHtml;
    }

    public void setcHtml(String cHtml) {
        this.cHtml = cHtml == null ? null : cHtml.trim();
    }

    public Timestamp getdSendTime() {
        return dSendTime;
    }

    public Timestamp getdOverdueTime() {
        return dOverdueTime;
    }

    public void setdSendTime(Timestamp dSendTime) {
        this.dSendTime = dSendTime;
    }

    public void setdOverdueTime(Timestamp dOverdueTime) {
        this.dOverdueTime = dOverdueTime;
    }

}