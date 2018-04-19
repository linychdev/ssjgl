package com.ustb.ssjgl.main.dao;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;

public interface IPotentialsFunctionDao extends IAbstractDao {
    
    /**
     * 新增函数
     * @param function
     */
    public void addFunction(TPotentialsFunction function);

    /**
     * 修改函数
     * @param function
     */
    public void updateFunction(TPotentialsFunction function);
    
    
    /**
     * 删除函数
     * @param functionId
     */
    public void deleteFunction(String functionId);
}
