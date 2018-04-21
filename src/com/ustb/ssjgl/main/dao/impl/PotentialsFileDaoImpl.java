package com.ustb.ssjgl.main.dao.impl;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.main.dao.IPotentialsFileDao;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;

public class PotentialsFileDaoImpl extends AbstractDao implements IPotentialsFileDao {

    private String mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.TPotentialsFileMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.";
    }
    
    @Override
    public void addPtentialsFile(TPotentialsFile ptenFile) {
        insertSelective(ptenFile);
    }

    @Override
    public void deletePtentialsFileById(String id) {
        deleteByPrimaryKey(TPotentialsFile.class, id);
    }

    @Override
    public void deleteByCombId(String combId) {
        String statement = mapperNamespace + ".deleteByCombId";
        this.getSqlSession().delete(statement, combId);
    }

    @Override
    public TPotentialsFile selectByCombId(String combId) {
        String statement = mapperNamespace + ".selectByCombId";
        return this.getSqlSession().selectOne(statement, combId);
    }

}
