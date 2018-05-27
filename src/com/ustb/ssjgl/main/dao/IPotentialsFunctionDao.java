package com.ustb.ssjgl.main.dao;

import java.util.List;

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

    /**
     * 根据组合id查找函数列表
     * @param combId
     * @return
     */
    public List<TPotentialsFunction> selectByCombId(String combId);

    /**
     * 查询出全部有效函数
     */
    public List<TPotentialsFunction> selectAll();
}
