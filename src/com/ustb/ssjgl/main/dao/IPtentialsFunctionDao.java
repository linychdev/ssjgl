package com.ustb.ssjgl.main.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TElementCombination;
import com.ustb.ssjgl.main.dao.bean.TPtentialsFunction;

public interface IPtentialsFunctionDao extends IAbstractDao {
    
    /**
     * 新增函数
     * @param function
     */
    public void addFunction(TPtentialsFunction function);

    /**
     * 修改函数
     * @param function
     */
    public void updateFunction(TPtentialsFunction function);
    
    /**
     * 根据元素组合获取函数列表
     * @param elementComb
     * @return
     */
    public List<TPtentialsFunction> getFunByElementComb(TElementCombination elementComb);
}
