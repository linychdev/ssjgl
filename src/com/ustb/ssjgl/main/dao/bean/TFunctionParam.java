package com.ustb.ssjgl.main.dao.bean;

import java.sql.Timestamp;

import com.ustb.ssjgl.common.SsjglContants;
import com.ustb.ssjgl.common.utils.DateUtils;
import com.ustb.ssjgl.common.utils.UuidUtils;

public class TFunctionParam {
    /** 主键 */
    private String cId;

    /** 函数主键 */
    private String cFunctionId;

    /** 参数名 */
    private String cName;
    
    /** 参数名的html串 */
    private String cNameHtml;

    /** 参数单位 */
    private String cUnit;

    /** 参数描述 */
    private String cDescription;

    /** 排序字段 */
    private Integer nOrder;

    /** 是否有效 */
    private Integer nValid;

    /** 时间戳 */
    private Timestamp dTime;

    public TFunctionParam() {
        super();
        this.cId = UuidUtils.getUuid();
        this.nValid = SsjglContants.COMMON_VALID;
        this.dTime = DateUtils.getCurrentDate();
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcFunctionId() {
        return cFunctionId;
    }

    public void setcFunctionId(String cFunctionId) {
        this.cFunctionId = cFunctionId == null ? null : cFunctionId.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcNameHtml() {
        return cNameHtml;
    }

    public void setcNameHtml(String cNameHtml) {
        this.cNameHtml = cNameHtml == null ? null : cNameHtml.trim();
    }

    
    public String getcUnit() {
        return cUnit;
    }

    public void setcUnit(String cUnit) {
        this.cUnit = cUnit == null ? null : cUnit.trim();
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription == null ? null : cDescription.trim();
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