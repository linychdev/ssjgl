package com.ustb.ssjgl.main.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TCombParam;

public interface ICombParamDao extends IAbstractDao {
    
    /**
     * 新增元素组合公式参数
     * @param combParam
     */
    public void addCombParam(TCombParam combParam); 

    /**
     * 批量新增元素组合的参数
     * @param combParamList
     */
    public void addCombParams(List<TCombParam> combParamList);
    
    /**
     * 根据id删除参数
     * @param id
     */
    public void deleteCombParamById(String id);

    /**
     * 根据元素组合id删除参数
     * @param combId
     */
    public void deleteCombParamByCombId(String combId);

    /**
     * 根据元素组合id和函数id删除参数
     * @param combId
     * @param funId
     */
    public void deleteCombParamByCombIdAndFunId(String combId, String funId);
}
