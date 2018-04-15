package com.ustb.ssjgl.main.dao;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TPtentialsScope;

public interface IPtentialsScopeDao extends IAbstractDao {
    
    /**
     * 新增势类型
     * @param ptenScope
     */
    public void addPtentialsScope(TPtentialsScope ptenScope);
}
