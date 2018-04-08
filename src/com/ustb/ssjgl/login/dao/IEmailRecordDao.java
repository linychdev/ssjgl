package com.ustb.ssjgl.login.dao;

import java.util.List;

import com.ustb.ssjgl.login.dao.bean.TEmailRecord;

public interface IEmailRecordDao {
    
    public List<String> getValidVerificationCodeByEmail(String email);
    
    public void saveEmailRecord(TEmailRecord emailRecord);
}
