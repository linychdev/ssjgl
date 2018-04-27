package com.ustb.ssjgl.visitlog.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.visitlog.dao.bean.TLoginRecord;

public interface ILoginRecordDao extends IAbstractDao {

    void batchInsert(List<TLoginRecord> loginRecordList);

}
