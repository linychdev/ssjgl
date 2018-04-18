package com.ustb.ssjgl.main.dao.bean;

import java.sql.Timestamp;

import com.ustb.ssjgl.common.SsjglContants;
import com.ustb.ssjgl.common.utils.DateUtils;
import com.ustb.ssjgl.common.utils.UuidUtils;

public class TPotentialsFunction {
    /** 主键 */
    private String cId;

    /** 体系主键 */
    private String cScopeId;

    /** 函数名 */
    private String cName;

    /** 函数公式 */
    private String cFormula;

    /** 描述 */
    private String cDescription;

    /** 是否有效 */
    private Integer nValid;

    /** 时间戳 */
    private Timestamp dTime;

    /** 函数公式的html串 */
    private String cFormulaHtml;

    /** 函数公式图片 */
    private byte[] bImage;

    public TPotentialsFunction() {
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

    public String getcScopeId() {
        return cScopeId;
    }

    public void setcScopeId(String cScopeId) {
        this.cScopeId = cScopeId == null ? null : cScopeId.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcFormula() {
        return cFormula;
    }

    public void setcFormula(String cFormula) {
        this.cFormula = cFormula == null ? null : cFormula.trim();
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription == null ? null : cDescription.trim();
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

    public String getcFormulaHtml() {
        return cFormulaHtml;
    }

    public void setcFormulaHtml(String cFormulaHtml) {
        this.cFormulaHtml = cFormulaHtml == null ? null : cFormulaHtml.trim();
    }

    public byte[] getbImage() {
        return bImage;
    }

    public void setbImage(byte[] bImage) {
        this.bImage = bImage;
    }
}