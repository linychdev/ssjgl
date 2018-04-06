package com.ustb.ssjgl.login.dao.bean;

public class TRole {
    private String cId;

    private String cRole;

    private String cRoleName;

    private Integer nValid;

    private Integer nOrder;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcRole() {
        return cRole;
    }

    public void setcRole(String cRole) {
        this.cRole = cRole == null ? null : cRole.trim();
    }

    public String getcRoleName() {
        return cRoleName;
    }

    public void setcRoleName(String cRoleName) {
        this.cRoleName = cRoleName == null ? null : cRoleName.trim();
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
}