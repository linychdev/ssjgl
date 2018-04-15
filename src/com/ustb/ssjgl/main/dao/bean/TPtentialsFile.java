package com.ustb.ssjgl.main.dao.bean;

import java.sql.Timestamp;
import java.util.Date;

public class TPtentialsFile {
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
    private Integer nSize;

    /** 是否有效 */
    private Integer nValid;

    /** 上传时间 */
    private Date dUploadTime;

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

    public Integer getnSize() {
        return nSize;
    }

    public void setnSize(Integer nSize) {
        this.nSize = nSize;
    }

    public Integer getnValid() {
        return nValid;
    }

    public void setnValid(Integer nValid) {
        this.nValid = nValid;
    }

    public Date getdUploadTime() {
        return dUploadTime;
    }

    public void setdUploadTime(Date dUploadTime) {
        this.dUploadTime = dUploadTime;
    }

    public Timestamp getdTime() {
        return dTime;
    }

    public void setdTime(Timestamp dTime) {
        this.dTime = dTime;
    }
}