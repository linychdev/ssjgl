package com.ustb.ssjgl.main.dao.impl;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.main.dao.IPotentialsScopeDao;
import com.ustb.ssjgl.main.dao.bean.TPotentialsScope;

public class PotentialsScopeDaoImpl extends AbstractDao implements IPotentialsScopeDao {

    @Override
    public void addPtentialsScope(TPotentialsScope ptenScope) {
        insertSelective(ptenScope);
    }

    @Override
    public void deletePtentialsScopeById(String id) {
        deleteByPrimaryKey(TPotentialsScope.class, id);
    }

    @Override
    public void updatePtentialsScopeById(TPotentialsScope ptenScope) {
        update(ptenScope);
    }

}
