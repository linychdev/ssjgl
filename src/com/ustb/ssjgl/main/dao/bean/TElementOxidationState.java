package com.ustb.ssjgl.main.dao.bean;

import java.sql.Timestamp;

public class TElementOxidationState {
    /** 主键 */
    private String cId;

    /** 元素主键 */
    private String cElementId;

    /** 氧化态 */
    private Integer nOxidationState;

    /** 氧化态 */
    private String cOxidationState;

    /** 排序 */
    private Integer nOrder;

    /** 是否有效 */
    private Integer nValid;

    /** 时间戳 */
    private Timestamp dTime;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcElementId() {
        return cElementId;
    }

    public void setcElementId(String cElementId) {
        this.cElementId = cElementId == null ? null : cElementId.trim();
    }

    public Integer getnOxidationState() {
        return nOxidationState;
    }

    public void setnOxidationState(Integer nOxidationState) {
        this.nOxidationState = nOxidationState;
    }

    public String getcOxidationState() {
        return cOxidationState;
    }

    public void setcOxidationState(String cOxidationState) {
        this.cOxidationState = cOxidationState == null ? null : cOxidationState.trim();
    }

    public Integer getnOrder() {
        return nOrder;
    }

    public void setnOrder(Integer nOrder) {
        this.nOrder = nOrder;
    }

    public Integer getnValid() {
        return nValid;
    }

    public void setnValid(Integer nValid) {
        this.nValid = nValid;
    }

    public Timestamp getdTime() {
        return dTime;
    }

    public void setdTime(Timestamp dTime) {
        this.dTime = dTime;
    }
}