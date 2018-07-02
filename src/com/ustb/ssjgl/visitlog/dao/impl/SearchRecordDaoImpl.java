package com.ustb.ssjgl.visitlog.dao.impl;

import java.util.List;
import java.util.Map;

import com.google.common.collect.Maps;
import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.visitlog.dao.ISearchRecordDao;
import com.ustb.ssjgl.visitlog.dao.bean.SearchRecordInfo;
import com.ustb.ssjgl.visitlog.dao.bean.TSearchRecord;

public class SearchRecordDaoImpl extends AbstractDao implements ISearchRecordDao {
    private String mapperNamespace = "com.ustb.ssjgl.visitlog.dao.mappings.TSearchRecordMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.visitlog.dao.mappings.";
    }
    @Override
    public void batchInsert(List<TSearchRecord> searchRecordList) {
        String statement = mapperNamespace + ".batchInsert";
        this.getSqlSession().insert(statement, searchRecordList);
    }
    
    @Override
    public List<Map<String, Integer>> getHotSearchListByBeginEnd(
            String beginDate, String endDate) {
        Map<String, String> filter = Maps.newHashMap();
        filter.put("beginDate", beginDate);
        filter.put("endDate", endDate);
        String statement = mapperNamespace + ".selectHotSearchListByBeginEnd";
        return this.getSqlSession().selectList(statement, filter);
    }
    @Override
    public List<Map<String, Integer>> getInvalidSearchListByBeginEnd(
            String beginDate, String endDate) {
        Map<String, String> filter = Maps.newHashMap();
        filter.put("beginDate", beginDate);
        filter.put("endDate", endDate);
        String statement = mapperNamespace + ".selectInvalidSearchListByBeginEnd";
        return this.getSqlSession().selectList(statement, filter);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.visitlog.dao.ISearchRecordDao#getHotPotenListByBeginEnd(java.lang.String, java.lang.String)
     */
    @Override
    public List<Map<String, Integer>> getHotPotenListByBeginEnd(String beginDate, String endDate) {
        Map<String, String> filter = Maps.newHashMap();
        filter.put("beginDate", beginDate);
        filter.put("endDate", endDate);
        String statement = mapperNamespace + ".selectHotPotenListByBeginEnd";
        return this.getSqlSession().selectList(statement, filter);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.visitlog.dao.ISearchRecordDao#getCountByFilter(java.util.Map)
     */
    @Override
    public int getCountByFilter(Map<String, Object> filter) {
        // TODO Auto-generated method stub
        return 0;
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.visitlog.dao.ISearchRecordDao#getSearchRecordInfoByFilter(java.util.Map)
     */
    @Override
    public List<SearchRecordInfo> getSearchRecordInfoByFilter(Map<String, Object> filter) {
        // TODO Auto-generated method stub
        return null;
    }

}
