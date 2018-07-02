package com.ustb.ssjgl.visitlog.service.impl;


import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.ustb.ssjgl.common.paging.Page;
import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.visitlog.dao.IDownloadRecordDao;
import com.ustb.ssjgl.visitlog.dao.ILoginRecordDao;
import com.ustb.ssjgl.visitlog.dao.IOperateRecordDao;
import com.ustb.ssjgl.visitlog.dao.ISearchElementDao;
import com.ustb.ssjgl.visitlog.dao.ISearchRecordDao;
import com.ustb.ssjgl.visitlog.dao.bean.TDownloadRecord;
import com.ustb.ssjgl.visitlog.dao.bean.TLoginRecord;
import com.ustb.ssjgl.visitlog.dao.bean.TOperateRecord;
import com.ustb.ssjgl.visitlog.dao.bean.TSearchElement;
import com.ustb.ssjgl.visitlog.dao.bean.TSearchRecord;
import com.ustb.ssjgl.visitlog.service.IVisitLogService;

@Service
public class VisitLogService implements IVisitLogService {
    
    private static final Logger LOG = LogUtils.getLogger();
    
    private ConcurrentLinkedQueue<TLoginRecord> loginQueue = new ConcurrentLinkedQueue<TLoginRecord>();
    private ConcurrentLinkedQueue<TSearchRecord> searchQueue = new ConcurrentLinkedQueue<TSearchRecord>();
    private ConcurrentLinkedQueue<TSearchElement> searchElementQueue = new ConcurrentLinkedQueue<TSearchElement>();
    private ConcurrentLinkedQueue<TOperateRecord> operateQueue = new ConcurrentLinkedQueue<TOperateRecord>();
    private ConcurrentLinkedQueue<TDownloadRecord> downloadQueue = new ConcurrentLinkedQueue<TDownloadRecord>();
    
    @Autowired
    private IDownloadRecordDao downloadRecordDao;
    
    @Autowired
    private ILoginRecordDao loginRecordDao;
    
    @Autowired
    private IOperateRecordDao operateRecordDao;
    
    @Autowired
    private ISearchElementDao searchElementDao;
    
    @Autowired
    private ISearchRecordDao searchRecordDao;
    
    @Override
    public void flushLogToDb() {
        try {
            List<TLoginRecord> loginRecordList = pollQueueElements(TLoginRecord.class);
            List<TSearchRecord> searchRecordList = pollQueueElements(TSearchRecord.class);
            List<TSearchElement> searchElementList = pollQueueElements(TSearchElement.class);
            List<TOperateRecord> operateRecordList = pollQueueElements(TOperateRecord.class);
            List<TDownloadRecord> downLoadRecordList = pollQueueElements(TDownloadRecord.class);

            if(CollectionUtils.isNotEmpty(loginRecordList)){
                loginRecordDao.batchInsert(loginRecordList);
            }
            if(CollectionUtils.isNotEmpty(searchRecordList)){
                searchRecordDao.batchInsert(searchRecordList);
            }
            if(CollectionUtils.isNotEmpty(searchElementList)){
                searchElementDao.batchInsert(searchElementList);
            }
            if(CollectionUtils.isNotEmpty(operateRecordList)){
                operateRecordDao.batchInsert(operateRecordList);
            }
            if(CollectionUtils.isNotEmpty(downLoadRecordList)){
                downloadRecordDao.batchInsert(downLoadRecordList);
            }
        } catch (Exception e) {
            LOG.warn("将队列中的访问信息写入数据库时出错！", e);
        }

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
    private <T> List<T> pollQueueElements(Class<T> element) {
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

    @Override
    public int getTotalVisitTimes(String beginDate, String endDate) {
        return operateRecordDao.getVisitTimes(beginDate, endDate);
    }

    @Override
    public int getIndexPageVisitTimes(String beginDate, String endDate) {
        return operateRecordDao.getIndexVisitTimes(beginDate, endDate);
    }

    @Override
    public int getDisIpVisitTimes(String beginDate, String endDate) {
        return operateRecordDao.getDisIpVisitTimes(beginDate, endDate);
    }

    @Override
    public List<Map<String, Integer>> getDaylyVisitTimes(String beginDate,
            String endDate) {
        return operateRecordDao.getDaylyVisitTimes(beginDate, endDate);
    }

    @Override
    public List<Map<String, Integer>> getHotSearchList(String beginDate,
            String endDate) {
        return searchRecordDao.getHotSearchListByBeginEnd(beginDate, endDate);
    }

    @Override
    public List<Map<String, Integer>> getInvalidSearchList(String beginDate,
            String endDate) {
        return searchRecordDao.getInvalidSearchListByBeginEnd(beginDate, endDate);
    }

    @Override
    public List<Map<String, Integer>> getHotPotenList(String beginDate,
            String endDate) {
        return searchRecordDao.getHotPotenListByBeginEnd(beginDate, endDate);
    }

    @Override
    public Page<?> getSearchListByPaging(Map<String, Object> filter,
            int pageSize, int pageIndex) {
        // TODO Auto-generated method stub
        return null;
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.visitlog.service.IVisitLogService#getDownloadListByPaging(java.util.Map, int, int)
     */
    @Override
    public Page<?> getDownloadListByPaging(Map<String, Object> filter, int pageSize, int pageIndex) {
        // TODO Auto-generated method stub
        return null;
    }
}
