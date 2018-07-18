package com.ustb.ssjgl.visitlog.dao;

import java.util.List;
import java.util.Map;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.visitlog.dao.bean.SearchRecordInfo;
import com.ustb.ssjgl.visitlog.dao.bean.TSearchRecord;

public interface ISearchRecordDao extends IAbstractDao {

    void batchInsert(List<TSearchRecord> searchRecordList);

    List<Map<String, Integer>> getHotSearchListByBeginEnd(String beginDate,
            String endDate);

    List<Map<String, Integer>> getInvalidSearchListByBeginEnd(String beginDate,
            String endDate);

    /**
     * @param beginDate
     * @param endDate
     * @return
     */
    List<Map<String, Integer>> getHotPotenListByBeginEnd(String beginDate, String endDate);

    /**
     * @param filter
     * @return
     */
    int getCountByFilter(Map<String, Object> filter);

    /**
     * @param filter
     * @return
     */
    List<SearchRecordInfo> getSearchRecordInfoByFilter(Map<String, Object> filter);

    List<Map<String, Object>> getValidHotPotenList();

}
