package com.ustb.ssjgl.main.dao.bean;

import java.sql.Timestamp;

public class TElementCombTag {
    /** 主键 */
    private String cId;

    /** 元素组合主键 */
    private String cElementCombId;

    /** 标签符号 */
    private String cTag;

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

    public String getcElementCombId() {
        return cElementCombId;
    }

    public void setcElementCombId(String cElementCombId) {
        this.cElementCombId = cElementCombId == null ? null : cElementCombId.trim();
    }

    public String getcTag() {
        return cTag;
    }

    public void setcTag(String cTag) {
        this.cTag = cTag == null ? null : cTag.trim();
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