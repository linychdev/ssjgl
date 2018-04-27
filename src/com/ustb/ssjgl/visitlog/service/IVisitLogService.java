package com.ustb.ssjgl.visitlog.service;



public interface IVisitLogService {
    public void flushLogToDb();
    
    public void addQueueElement(Object element);
}
