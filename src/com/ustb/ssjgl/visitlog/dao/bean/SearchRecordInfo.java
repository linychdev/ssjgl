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
    private Integer nValidSearch;
    private String cValid;
    
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
    public Integer getnValidSearch() {
        return nValidSearch;
    }
    public void setnValidSearch(Integer nValidSearch) {
        this.nValidSearch = nValidSearch;
    }
    public void setResultNumber(Integer resultNumber) {
        this.resultNumber = resultNumber;
    }
    public String getcValid() {
        if(Integer.valueOf(1).equals(nValidSearch)){
            return "是";
        }else{
            return "否";
        }
    }
    public void setcValid(String cValid) {
        this.cValid = cValid;
    }
}
