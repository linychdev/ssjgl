package com.ustb.ssjgl.visitlog.service;

import java.util.List;
import java.util.Map;



public interface IVisitLogService {
    public void flushLogToDb();
    
    public void addQueueElement(Object element);
    
    
    public int getTotalVisitTimes(String beginDate, String endDate);
    public int getIndexPageVisitTimes(String beginDate, String endDate);
    public int getDisIpVisitTimes(String beginDate, String endDate);
    public List<Map<String,Integer>> getDaylyVisitTimes(String beginDate, String endDate);
}
