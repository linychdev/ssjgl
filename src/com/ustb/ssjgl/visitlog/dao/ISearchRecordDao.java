package com.ustb.ssjgl.visitlog.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.visitlog.dao.bean.TSearchRecord;

public interface ISearchRecordDao extends IAbstractDao {

    void batchInsert(List<TSearchRecord> searchRecordList);

}
