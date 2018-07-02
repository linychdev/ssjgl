package com.ustb.ssjgl.visitlog.service;

import java.util.List;
import java.util.Map;

import com.ustb.ssjgl.common.paging.Page;



public interface IVisitLogService {
    public void flushLogToDb();
    
    public void addQueueElement(Object element);
    
    
    public int getTotalVisitTimes(String beginDate, String endDate);
    public int getIndexPageVisitTimes(String beginDate, String endDate);
    public int getDisIpVisitTimes(String beginDate, String endDate);
    public List<Map<String,Integer>> getDaylyVisitTimes(String beginDate, String endDate);

    public List<Map<String, Integer>> getHotSearchList(String beginDate,
            String endDate);

    public List<Map<String, Integer>> getInvalidSearchList(String beginDate,
            String endDate);

    public List<Map<String, Integer>> getHotPotenList(String beginDate,
            String endDate);

    public Page<?> getSearchListByPaging(Map<String, Object> filter, int pageSize, int pageIndex);

    /**
     * @param filter
     * @param pageSize
     * @param pageIndex
     * @return
     */
    Page<?> getDownloadListByPaging(Map<String, Object> filter, int pageSize, int pageIndex);
}
