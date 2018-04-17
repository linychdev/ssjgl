package com.ustb.ssjgl.main.dao;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TPotentialsScope;

public interface IPotentialsScopeDao extends IAbstractDao {
    
    /**
     * 新增势类型
     * @param ptenScope
     */
    public void addPtentialsScope(TPotentialsScope ptenScope);
}
