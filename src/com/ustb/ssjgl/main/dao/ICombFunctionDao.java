package com.ustb.ssjgl.main.dao;

import java.util.List;

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

    /**
     * 批量为元素组合新增函数
     * @param combFunction
     */
    public void addCombFunctions(List<TCombFunction> combFunctions);

    /**
     * 根据组合id删除元素组合的函数
     * @param combId
     */
    public void deleteCombFunctionByCombId(String combId);

    /**
     * 根据组合id和函数id删除元素组合的函数
     * @param combId
     * @param functionId
     */
    public void deleteCombFunByCombIdAndFunId(String combId, String functionId);
    
}
