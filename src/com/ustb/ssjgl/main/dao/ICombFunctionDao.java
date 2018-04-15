package com.ustb.ssjgl.main.dao;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TCombFunction;

public interface ICombFunctionDao extends IAbstractDao {
    
    /**
     * 为元素组合新增函数
     * @param combFunction
     */
    public void addCombFunction(TCombFunction combFunction);

    /**
     * 根据id删除元素组合的函数
     * @param id
     */
    public void deleteCombFunctionById(String id);
    
}
