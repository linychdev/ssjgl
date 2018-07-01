package com.ustb.ssjgl.visitlog.dao.impl;

import java.util.List;
import java.util.Map;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.visitlog.dao.ISearchElementDao;
import com.ustb.ssjgl.visitlog.dao.bean.TSearchElement;

public class SearchElementDaoImpl extends AbstractDao implements ISearchElementDao {
    private String mapperNamespace = "com.ustb.ssjgl.visitlog.dao.mappings.TSearchElementMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.visitlog.dao.mappings.";
    }
    @Override
    public void batchInsert(List<TSearchElement> searchElementList) {
        String statement = mapperNamespace + ".batchInsert";
        this.getSqlSession().insert(statement, searchElementList);
    }
    @Override
    public List<Map<String, Integer>> getHotPotenListByBeginEnd(
            String beginDate, String endDate) {
        // TODO Auto-generated method stub
        return null;
    }

}
