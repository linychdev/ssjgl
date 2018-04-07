package com.ustb.ssjgl.login.dao.bean;

import java.util.Date;

import com.ustb.ssjgl.common.SsjglContants;
import com.ustb.ssjgl.common.utils.DateUtils;
import com.ustb.ssjgl.common.utils.SsjglUtils;

public class TUser {
    private String cId;

    private String cLoginName;

    private String cPassword;

    private Integer nIslock;

    private String cEmail;

    private String cName;

    private String cOrg;

    private String cPhone;

    private Integer nValid;

    private Integer nOrder;

    private String cNote;

    private Date dCreateTime;

    private Date dTime;

    public TUser(){
        super();
        this.cId = SsjglUtils.getUuid();
        this.nIslock = SsjglContants.USER_LOCK_NO;
        this.nValid = SsjglContants.USER_VALID_YES;
        this.dCreateTime = DateUtils.getCurrentDate();
        this.dTime = DateUtils.getCurrentDate();
    }
    

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcLoginName() {
        return cLoginName;
    }

    public void setcLoginName(String cLoginName) {
        this.cLoginName = cLoginName == null ? null : cLoginName.trim();
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword == null ? null : cPassword.trim();
    }

    public Integer getnIslock() {
        return nIslock;
    }

    public void setnIslock(Integer nIslock) {
        this.nIslock = nIslock;
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail == null ? null : cEmail.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcOrg() {
        return cOrg;
    }

    public void setcOrg(String cOrg) {
        this.cOrg = cOrg == null ? null : cOrg.trim();
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone == null ? null : cPhone.trim();
    }

    public Integer getnValid() {
        return nValid;
    }

    public void setnValid(Integer nValid) {
        this.nValid = nValid;
    }

    public Integer getnOrder() {
        return nOrder;
    }

    public void setnOrder(Integer nOrder) {
        this.nOrder = nOrder;
    }

    public String getcNote() {
        return cNote;
    }

    public void setcNote(String cNote) {
        this.cNote = cNote == null ? null : cNote.trim();
    }

    public Date getdCreateTime() {
        return dCreateTime;
    }

    public void setdCreateTime(Date dCreateTime) {
        this.dCreateTime = dCreateTime;
    }

    public Date getdTime() {
        return dTime;
    }

    public void setdTime(Date dTime) {
        this.dTime = dTime;
    }
}