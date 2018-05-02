package com.ustb.ssjgl.visitlog.dao.impl;

import java.util.List;

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

}
