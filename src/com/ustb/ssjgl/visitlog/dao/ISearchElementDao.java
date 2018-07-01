package com.ustb.ssjgl.visitlog.dao;

import java.util.List;
import java.util.Map;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.visitlog.dao.bean.TSearchElement;

public interface ISearchElementDao extends IAbstractDao {

    void batchInsert(List<TSearchElement> searchElementList);

    List<Map<String, Integer>> getHotPotenListByBeginEnd(String beginDate,
            String endDate);

}
