package com.ustb.ssjgl.login.dao.impl;

import java.util.List;

import com.google.common.collect.Lists;
import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.login.dao.IEmailRecordDao;
import com.ustb.ssjgl.login.dao.bean.TEmailRecord;

public class EmaiRecordDaoImpl extends AbstractDao implements IEmailRecordDao{

    private String mapperNamespace = "com.ustb.ssjgl.login.dao.mappings.TEmailRecordMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.login.dao.mappings.";
    }
    
    @Override
    public List<String> getValidVerificationCodeByEmail(String emailAddress) {
        String statement = mapperNamespace + ".selectRecordByEmail";
        List<TEmailRecord> recordList = this.getSqlSession().selectList(statement, emailAddress);
        List<String> vvcList = Lists.newArrayList();
        for (TEmailRecord record : recordList) {
            vvcList.add(record.getcVerificationCode());
        }
        return vvcList; 
    }

    @Override
    public void saveEmailRecord(TEmailRecord emailRecord) {
        insertSelective(emailRecord);
    }

}
