package com.ustb.ssjgl.visitlog.dao;

import java.util.List;
import java.util.Map;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.visitlog.dao.bean.PotenFileDownloadInfo;
import com.ustb.ssjgl.visitlog.dao.bean.TDownloadRecord;

public interface IDownloadRecordDao extends IAbstractDao {

    void batchInsert(List<TDownloadRecord> downLoadRecordList);

    /**
     * @param filter
     * @return
     */
    int getCountByFilter(Map<String, Object> filter);

    /**
     * @param filter
     * @return
     */
    List<PotenFileDownloadInfo> getPfdiByFilter(Map<String, Object> filter);

    /**
     * @return
     */
    int getCount();

}
