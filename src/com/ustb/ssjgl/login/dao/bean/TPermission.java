package com.ustb.ssjgl.login.dao.bean;

public class TPermission {
    private String cId;

    private String cPermission;

    private String cPermissionName;

    private Integer nValid;

    private Integer nOrder;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcPermission() {
        return cPermission;
    }

    public void setcPermission(String cPermission) {
        this.cPermission = cPermission == null ? null : cPermission.trim();
    }

    public String getcPermissionName() {
        return cPermissionName;
    }

    public void setcPermissionName(String cPermissionName) {
        this.cPermissionName = cPermissionName == null ? null : cPermissionName.trim();
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