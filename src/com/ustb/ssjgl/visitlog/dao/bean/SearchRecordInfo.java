package com.ustb.ssjgl.visitlog.dao.bean;

/**
 * SearchRecordInfo
 * @author linych
 * @version 1.0
 *
 */
public class SearchRecordInfo {
    private String searchText;
    private Integer searchTimes;
    private Integer resultNumber;
    public String getSearchText() {
        return searchText;
    }
    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }
    public Integer getSearchTimes() {
        return searchTimes;
    }
    public void setSearchTimes(Integer searchTimes) {
        this.searchTimes = searchTimes;
    }
    public Integer getResultNumber() {
        return resultNumber;
    }
    public void setResultNumber(Integer resultNumber) {
        this.resultNumber = resultNumber;
    }
}
