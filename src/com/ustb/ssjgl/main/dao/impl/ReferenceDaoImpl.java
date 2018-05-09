package com.ustb.ssjgl.main.dao.impl;

import java.util.List;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.main.dao.IReferenceDao;
import com.ustb.ssjgl.main.dao.bean.TReference;

public class ReferenceDaoImpl extends AbstractDao implements IReferenceDao {
    private String mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.TReferenceMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.";
    }
    @Override
    public List<TReference> selectByCombId(String combId) {
        String statement = mapperNamespace + ".selectByCombId";
        return this.getSqlSession().selectList(statement, combId);
    }

}
