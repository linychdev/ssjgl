package com.ustb.ssjgl.visitlog.dao;

import java.util.List;
import java.util.Map;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.visitlog.dao.bean.TSearchRecord;

public interface ISearchRecordDao extends IAbstractDao {

    void batchInsert(List<TSearchRecord> searchRecordList);

    List<Map<String, Integer>> getHotSearchListByBeginEnd(String beginDate,
            String endDate);

    List<Map<String, Integer>> getInvalidSearchListByBeginEnd(String beginDate,
            String endDate);

}
