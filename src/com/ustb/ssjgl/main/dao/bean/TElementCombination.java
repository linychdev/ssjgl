package com.ustb.ssjgl.main.dao.bean;

import java.sql.Timestamp;

import com.ustb.ssjgl.common.SsjglContants;
import com.ustb.ssjgl.common.utils.DateUtils;
import com.ustb.ssjgl.common.utils.UuidUtils;

public class TElementCombination {
    /** 主键 */
    private String cId;

    /** 体系主键 */
    private String cScopeId;
    
    /** 组合名称 */
    private String cCombName;

    /** 组合描述 */
    private String cDescription;

    /** 参考文献总体描述 */
    private String cReferenceDescription;

    /** 备注 */
    private String cNote;

    /** 排序字段 */
    private Integer nOrder;

    /** 是否有效 */
    private Integer nValid;

    /** 创建时间 */
    private Timestamp dCreateTime;

    /** 时间戳 */
    private Timestamp dTime;
    
    public TElementCombination() {
        super();
        this.cId = UuidUtils.getUuid();
        this.nValid = SsjglContants.COMMON_VALID;
        this.dCreateTime = DateUtils.getCurrentDate();
        this.dTime = DateUtils.getCurrentDate();
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }
    
    public String getcScopeId() {
        return cScopeId;
    }

    public void setcScopeId(String cScopeId) {
        this.cScopeId = cScopeId == null ? null : cScopeId.trim();
    }

    public String getcCombName() {
        return cCombName;
    }

    public void setcCombName(String cCombName) {
        this.cCombName = cCombName == null ? null : cCombName.trim();
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription == null ? null : cDescription.trim();
    }

    public String getcReferenceDescription() {
        return cReferenceDescription;
    }

    public void setcReferenceDescription(String cReferenceDescription) {
        this.cReferenceDescription = cReferenceDescription == null ? null : cReferenceDescription.trim();
    }

    public String getcNote() {
        return cNote;
    }

    public void setcNote(String cNote) {
        this.cNote = cNote == null ? null : cNote.trim();
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

    public Timestamp getdCreateTime() {
        return dCreateTime;
    }

    public void setdCreateTime(Timestamp dCreateTime) {
        this.dCreateTime = dCreateTime;
    }

    public Timestamp getdTime() {
        return dTime;
    }

    public void setdTime(Timestamp dTime) {
        this.dTime = dTime;
    }
}