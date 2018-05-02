package com.ustb.ssjgl.visitlog.dao.impl;

import java.util.List;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.visitlog.dao.ILoginRecordDao;
import com.ustb.ssjgl.visitlog.dao.bean.TLoginRecord;

public class LoginRecordDaoImpl extends AbstractDao implements ILoginRecordDao {

    private String mapperNamespace = "com.ustb.ssjgl.visitlog.dao.mappings.TLoginRecordMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.visitlog.dao.mappings.";
    }
    
    @Override
    public void batchInsert(List<TLoginRecord> loginRecordList) {
        String statement = mapperNamespace + ".batchInsert";
        this.getSqlSession().insert(statement, loginRecordList);
    }

}
