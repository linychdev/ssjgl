package com.ustb.ssjgl.visitlog.service.impl;


import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ustb.ssjgl.visitlog.dao.bean.TDownloadRecord;
import com.ustb.ssjgl.visitlog.dao.bean.TLoginRecord;
import com.ustb.ssjgl.visitlog.dao.bean.TOperateRecord;
import com.ustb.ssjgl.visitlog.dao.bean.TSearchElement;
import com.ustb.ssjgl.visitlog.dao.bean.TSearchRecord;
import com.ustb.ssjgl.visitlog.service.IVisitLogService;

@Service
public class VisitLogService implements IVisitLogService {
    
    ConcurrentLinkedQueue<TLoginRecord> loginQueue = new ConcurrentLinkedQueue<TLoginRecord>();
    ConcurrentLinkedQueue<TSearchRecord> searchQueue = new ConcurrentLinkedQueue<TSearchRecord>();
    ConcurrentLinkedQueue<TSearchElement> searchElementQueue = new ConcurrentLinkedQueue<TSearchElement>();
    ConcurrentLinkedQueue<TOperateRecord> operateQueue = new ConcurrentLinkedQueue<TOperateRecord>();
    ConcurrentLinkedQueue<TDownloadRecord> downloadQueue = new ConcurrentLinkedQueue<TDownloadRecord>();
    
//    private 
    
    @Override
    public void flushLogToDb() {
        // TODO Auto-generated method stub
        
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.visitlog.service.IVisitLogService#addQueueElement(java.lang.Class)
     */
    @Override
    public void addQueueElement(Object element) {
        if(TLoginRecord.class.isInstance(element)){
            loginQueue.offer((TLoginRecord) element);
        }
        if(TSearchRecord.class.isInstance(element)){
            searchQueue.offer((TSearchRecord) element);
        }
        if(TSearchElement.class.isInstance(element)){
            searchElementQueue.offer((TSearchElement) element);
        }
        if(TOperateRecord.class.isInstance(element)){
            operateQueue.offer((TOperateRecord) element);
        }
        if(TDownloadRecord.class.isInstance(element)){
            downloadQueue.offer((TDownloadRecord) element);
        }
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    public <T> List<T> pollQueueElements(Class<T> element) {
        List<T> list = Lists.newArrayList();
        if (TLoginRecord.class.isAssignableFrom(element)) {
            while (!loginQueue.isEmpty()) {
                list.add((T) loginQueue.poll());
            }
        }
        if (TSearchRecord.class.isAssignableFrom(element)) {
            while (!searchQueue.isEmpty()) {
                list.add((T) searchQueue.poll());
            }
        }
        if (TSearchElement.class.isAssignableFrom(element)) {
            while (!searchElementQueue.isEmpty()) {
                list.add((T) searchElementQueue.poll());
            }
        }
        if (TOperateRecord.class.isAssignableFrom(element)) {
            while (!operateQueue.isEmpty()) {
                list.add((T) operateQueue.poll());
            }
        }
        if (TDownloadRecord.class.isAssignableFrom(element)) {
            while (!downloadQueue.isEmpty()) {
                list.add((T) downloadQueue.poll());
            }
        }
        return list;
    }
}
