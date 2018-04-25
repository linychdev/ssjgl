package com.ustb.ssjgl.main.dao.bean;

public class TSearchElement {
    /** Ö÷¼ü */
    private String cId;

    /** ËÑË÷¼ÇÂ¼Ö÷¼ü */
    private String cSearchId;

    /** ËÑË÷ÔªËØÖ÷¼ü */
    private String cElementId;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcSearchId() {
        return cSearchId;
    }

    public void setcSearchId(String cSearchId) {
        this.cSearchId = cSearchId == null ? null : cSearchId.trim();
    }

    public String getcElementId() {
        return cElementId;
    }

    public void setcElementId(String cElementId) {
        this.cElementId = cElementId == null ? null : cElementId.trim();
    }
}