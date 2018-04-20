package com.ustb.ssjgl.main.dao.bean;

import java.sql.Timestamp;

import com.ustb.ssjgl.common.SsjglContants;
import com.ustb.ssjgl.common.utils.DateUtils;
import com.ustb.ssjgl.common.utils.UuidUtils;

public class TPotentialsFile {
    /** 主键 */
    private String cId;

    /** 元素组合id */
    private String cElementCombId;

    /** 文件名 */
    private String cFileName;

    /** ftp地址 */
    private String cFtpUrlPath;
    
    /** 后缀 */
    private String cSuffix;

    /** 大小(单位:k) */
    private Long nSize;

    /** 是否有效 */
    private Integer nValid;

    /** 上传时间 */
    private Timestamp dUploadTime;

    /** 时间戳 */
    private Timestamp dTime;

    public TPotentialsFile() {
        super();
        this.cId = UuidUtils.getUuid();
        this.nValid = SsjglContants.COMMON_VALID;
        this.dUploadTime = DateUtils.getCurrentDate();
        this.dTime = DateUtils.getCurrentDate();
    }

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

    public String getcFileName() {
        return cFileName;
    }

    public void setcFileName(String cFileName) {
        this.cFileName = cFileName == null ? null : cFileName.trim();
    }

    public String getcFtpUrlPath() {
        return cFtpUrlPath;
    }

    public void setcFtpUrlPath(String cFtpUrlPath) {
        this.cFtpUrlPath = cFtpUrlPath == null ? null : cFtpUrlPath.trim();
    }

    public String getcSuffix() {
        return cSuffix;
    }

    public void setcSuffix(String cSuffix) {
        this.cSuffix = cSuffix == null ? null : cSuffix.trim();
    }

    public Long getnSize() {
        return nSize;
    }

    public void setnSize(Long nSize) {
        this.nSize = nSize;
    }

    public Integer getnValid() {
        return nValid;
    }

    public void setnValid(Integer nValid) {
        this.nValid = nValid;
    }

    public Timestamp getdUploadTime() {
        return dUploadTime;
    }

    public void setdUploadTime(Timestamp dUploadTime) {
        this.dUploadTime = dUploadTime;
    }

    public Timestamp getdTime() {
        return dTime;
    }

    public void setdTime(Timestamp dTime) {
        this.dTime = dTime;
    }
    
    public String getFtpFileName(){
        return this.cElementCombId + "." + this.cSuffix;
    }
}