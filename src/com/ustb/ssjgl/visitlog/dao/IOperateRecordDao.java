package com.ustb.ssjgl.visitlog.dao;

import java.util.List;
import java.util.Map;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.visitlog.dao.bean.TOperateRecord;

public interface IOperateRecordDao extends IAbstractDao {

    void batchInsert(List<TOperateRecord> operateRecordList);

    int getVisitTimes(String beginDate, String endDate);

    int getIndexVisitTimes(String beginDate, String endDate);

    int getDisIpVisitTimes(String beginDate, String endDate);

    List<Map<String, Integer>> getDaylyVisitTimes(String beginDate,
            String endDate);
}
