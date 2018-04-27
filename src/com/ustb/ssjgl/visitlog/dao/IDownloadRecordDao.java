package com.ustb.ssjgl.visitlog.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.visitlog.dao.bean.TDownloadRecord;

public interface IDownloadRecordDao extends IAbstractDao {

    void batchInsert(List<TDownloadRecord> downLoadRecordList);

}
