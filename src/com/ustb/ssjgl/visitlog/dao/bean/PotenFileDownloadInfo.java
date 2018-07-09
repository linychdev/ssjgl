/*
 * @(#)PotenFileDownloadInfo.java 2018年7月2日下午6:25:12
 * ssjgl
 * Copyright 2018 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ustb.ssjgl.visitlog.dao.bean;

/**
 * PotenFileDownloadInfo
 * @author linych
 * @version 1.0
 *
 */
public class PotenFileDownloadInfo {
    private Integer rownum;
    private String fileName;
    private Integer size;
    private Integer downLoadTimes;
    /**
     * @return the fileName
     */
    public String getFileName() {
        return fileName;
    }
    /**
     * @param fileName the fileName to set
     */
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    /**
     * @return the size
     */
    public Integer getSize() {
        return size;
    }
    /**
     * @param size the size to set
     */
    public void setSize(Integer size) {
        this.size = size;
    }
    /**
     * @return the downLoadTimes
     */
    public Integer getDownLoadTimes() {
        return downLoadTimes;
    }
    /**
     * @param downLoadTimes the downLoadTimes to set
     */
    public void setDownLoadTimes(Integer downLoadTimes) {
        this.downLoadTimes = downLoadTimes;
    }
    public Integer getRownum() {
        return rownum;
    }
    public void setRownum(Integer rownum) {
        this.rownum = rownum;
    }
}
