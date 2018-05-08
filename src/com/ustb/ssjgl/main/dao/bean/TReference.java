package com.ustb.ssjgl.main.dao.bean;

import java.util.Date;

public class TReference {
    /** 主键 */
    private String cId;

    /** 元素组合主键 */
    private String cElementCombId;

    /** 来源(1:势库,2:其他来源) */
    private Integer nSource;

    /** 文献内容 */
    private String cContent;

    /** 备注 */
    private String cNote;

    /** 论文id */
    private String cDoi;

    /** 排序字段 */
    private Integer nOrder;

    /** 是否有效 */
    private Integer nValid;

    /** 创建时间 */
    private Date dCreateTime;

    /** 时间戳 */
    private Date dTime;

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

    public Integer getnSource() {
        return nSource;
    }

    public void setnSource(Integer nSource) {
        this.nSource = nSource;
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent == null ? null : cContent.trim();
    }

    public String getcNote() {
        return cNote;
    }

    public void setcNote(String cNote) {
        this.cNote = cNote == null ? null : cNote.trim();
    }

    public String getcDoi() {
        return cDoi;
    }

    public void setcDoi(String cDoi) {
        this.cDoi = cDoi == null ? null : cDoi.trim();
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