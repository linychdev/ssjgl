package com.ustb.ssjgl.visitlog.dao.impl;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.visitlog.dao.IOperateRecordDao;
import com.ustb.ssjgl.visitlog.dao.bean.TOperateRecord;

public class OperateRecordDaoImpl extends AbstractDao implements IOperateRecordDao {
    private String mapperNamespace = "com.ustb.ssjgl.visitlog.dao.mappings.TOperateRecordMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.visitlog.dao.mappings.";
    }
    @Override
    public void batchInsert(List<TOperateRecord> operateRecordList) {
        String statement = mapperNamespace + ".batchInsert";
        this.getSqlSession().insert(statement, operateRecordList);
    }
    @Override
    public int getVisitTimes(String beginDate, String endDate) {
        Map<String, String> filter = Maps.newHashMap();
        filter.put("beginDate", beginDate);
        filter.put("endDate", endDate);
        String statement = mapperNamespace + ".selectVisitTimesByBeginEnd";
        return this.getSqlSession().selectOne(statement, filter);
    }
    @Override
    public int getIndexVisitTimes(String beginDate, String endDate) {
        Map<String, String> filter = Maps.newHashMap();
        filter.put("beginDate", beginDate);
        filter.put("endDate", endDate);
        String statement = mapperNamespace + ".selectIndexVisitTimesByBeginEnd";
        return this.getSqlSession().selectOne(statement, filter);
    }
    @Override
    public int getDisIpVisitTimes(String beginDate, String endDate) {
        Map<String, String> filter = Maps.newHashMap();
        filter.put("beginDate", beginDate);
        filter.put("endDate", endDate);
        String statement = mapperNamespace + ".selectDisIpVisitTimesByBeginEnd";
        return this.getSqlSession().selectOne(statement, filter);
    }
    @Override
    public List<Map<String, Integer>> getDaylyVisitTimes(String beginDate,
            String endDate) {
        Map<String, String> filter = Maps.newHashMap();
        filter.put("beginDate", beginDate);
        filter.put("endDate", endDate);
        String statement = mapperNamespace + ".selectDaylyVisitTimesByBeginEnd";
        return this.getSqlSession().selectList(statement, filter);
    }

}
