package com.ustb.ssjgl.visitlog.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.visitlog.dao.bean.TOperateRecord;

public interface IOperateRecordDao extends IAbstractDao {

    void batchInsert(List<TOperateRecord> operateRecordList);

}
