package com.ustb.ssjgl.main.dao.bean;

import java.sql.Timestamp;

public class TCombParam {
    /** 主键 */
    private String cId;

    /** 元素组合主键 */
    private String cElementCombId;

    /** 势函数主键 */
    private String cPtentialsFunctionId;

    /** 参数主键 */
    private String cParamId;

    /** 参数对类型 */
    private String cClass;

    /** 参数值 */
    private String cValue;

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

    public String getcPtentialsFunctionId() {
        return cPtentialsFunctionId;
    }

    public void setcPtentialsFunctionId(String cPtentialsFunctionId) {
        this.cPtentialsFunctionId = cPtentialsFunctionId == null ? null : cPtentialsFunctionId.trim();
    }

    public String getcParamId() {
        return cParamId;
    }

    public void setcParamId(String cParamId) {
        this.cParamId = cParamId == null ? null : cParamId.trim();
    }

    public String getcClass() {
        return cClass;
    }

    public void setcClass(String cClass) {
        this.cClass = cClass == null ? null : cClass.trim();
    }

    public String getcValue() {
        return cValue;
    }

    public void setcValue(String cValue) {
        this.cValue = cValue == null ? null : cValue.trim();
    }

    public Timestamp getdTime() {
        return dTime;
    }

    public void setdTime(Timestamp dTime) {
        this.dTime = dTime;
    }
}