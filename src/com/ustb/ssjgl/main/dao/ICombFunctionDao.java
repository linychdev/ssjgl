package com.ustb.ssjgl.main.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TCombFunction;
import com.ustb.ssjgl.main.dao.bean.TElementCombination;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;

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
    public void deleteByCombId(String combId);

    /**
     * 根据组合id和函数id删除元素组合的函数
     * @param combId
     * @param functionId
     */
    public void deleteByCombIdAndFunId(String combId, String functionId);
    
    /**
     * 根据元素组合主键获取函数列表
     * @param combId
     * @return
     */
    public List<TPotentialsFunction> getFunByElementCombId(String combId);

    /**
     * @param elementComb
     * @return
     */
    public List<TPotentialsFunction> getFunByElementComb(TElementCombination elementComb);
}
