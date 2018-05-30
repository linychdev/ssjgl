package com.ustb.ssjgl.main.dao;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TPotentialsScope;

public interface IPotentialsScopeDao extends IAbstractDao {
    
    /**
     * 新增势类型
     * @param ptenScope
     */
    public void addPotentialsScope(TPotentialsScope ptenScope);
    
    /**
     * 根据id删除势类型(删除前需要验证其下是否有函数)
     * @param id
     */
    public void deletePotentialsScopeById(String id);

    /**
     * 更新势类型
     * @param ptenScope
     */
    public void updatePotentialsScopeById(TPotentialsScope ptenScope);
}
