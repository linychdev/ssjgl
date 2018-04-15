package com.ustb.ssjgl.main.dao.bean;

import java.sql.Timestamp;

public class TElementCombDetail {
    /** 主键 */
    private String cId;

    /** 元素组合主键 */
    private String cElementCombId;

    /** 元素主键 */
    private String cElementId;

    /** 排序字段 */
    private Integer nOrder;

    /** 时间戳 */
    private Timestamp dTime;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcElementCombId() {
        return cElementCombId;
    }

    public void setcElementCombId(String cElementCombId) {
        this.cElementCombId = cElementCombId == null ? null : cElementCombId.trim();
    }

    public String getcElementId() {
        return cElementId;
    }

    public void setcElementId(String cElementId) {
        this.cElementId = cElementId == null ? null : cElementId.trim();
    }

    public Integer getnOrder() {
        return nOrder;
    }

    public void setnOrder(Integer nOrder) {
        this.nOrder = nOrder;
    }

    public Timestamp getdTime() {
        return dTime;
    }

    public void setdTime(Timestamp dTime) {
        this.dTime = dTime;
    }
}