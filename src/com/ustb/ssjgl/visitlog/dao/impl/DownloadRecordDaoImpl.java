package com.ustb.ssjgl.visitlog.dao.impl;

import java.util.List;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.visitlog.dao.IDownloadRecordDao;
import com.ustb.ssjgl.visitlog.dao.bean.TDownloadRecord;

public class DownloadRecordDaoImpl extends AbstractDao implements IDownloadRecordDao {
    private String mapperNamespace = "com.ustb.ssjgl.visitlog.dao.mappings.TDownloadRecordMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.visitlog.dao.mappings.";
    }

    @Override
    public void batchInsert(List<TDownloadRecord> downLoadRecordList) {
        String statement = mapperNamespace + ".batchInsert";
        this.getSqlSession().insert(statement, downLoadRecordList);

    }
}
