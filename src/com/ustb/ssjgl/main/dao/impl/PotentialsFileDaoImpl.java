package com.ustb.ssjgl.main.dao.impl;

import java.util.List;

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
    public void deleteByReferenceId(String referenceId) {
        String statement = mapperNamespace + ".deleteByReferenceId";
        this.getSqlSession().delete(statement, referenceId);
    }

    @Override
    public List<TPotentialsFile> selectByReferenceId(String referenceId) {
        String statement = mapperNamespace + ".selectByReferenceId";
        return this.getSqlSession().selectList(statement, referenceId);
    }

}
