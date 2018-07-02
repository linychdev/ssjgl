package com.ustb.ssjgl.visitlog.dao.impl;

import java.util.List;
import java.util.Map;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.visitlog.dao.IDownloadRecordDao;
import com.ustb.ssjgl.visitlog.dao.bean.PotenFileDownloadInfo;
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

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.visitlog.dao.IDownloadRecordDao#getCountByFilter(java.util.Map)
     */
    @Override
    public int getCount() {
        String statement = mapperNamespace + ".selectCount";
        return this.getSqlSession().selectOne(statement);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.visitlog.dao.IDownloadRecordDao#getCountByFilter(java.util.Map)
     */
    @Override
    public int getCountByFilter(Map<String, Object> filter) {
        String statement = mapperNamespace + ".selectCountByFilter";
        return this.getSqlSession().selectOne(statement, filter);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.visitlog.dao.IDownloadRecordDao#getPfdiByFilter(java.util.Map)
     */
    @Override
    public List<PotenFileDownloadInfo> getPfdiByFilter(Map<String, Object> filter) {
        String statement = mapperNamespace + ".selectByFilter";
        return this.getSqlSession().selectList(statement, filter);
    }
}
