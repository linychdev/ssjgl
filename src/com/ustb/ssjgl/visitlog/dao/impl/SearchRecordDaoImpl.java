package com.ustb.ssjgl.visitlog.dao.impl;

import java.util.List;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.visitlog.dao.ISearchRecordDao;
import com.ustb.ssjgl.visitlog.dao.bean.TSearchRecord;

public class SearchRecordDaoImpl extends AbstractDao implements ISearchRecordDao {
    private String mapperNamespace = "com.ustb.ssjgl.visitlog.dao.mappings.TSearchRecordMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.visitlog.dao.mappings.";
    }
    @Override
    public void batchInsert(List<TSearchRecord> searchRecordList) {
        String statement = mapperNamespace + ".batchInsert";
        this.getSqlSession().insert(statement, searchRecordList);
    }

}
