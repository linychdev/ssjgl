package com.ustb.ssjgl.main.service;

import java.util.List;

import com.ustb.ssjgl.main.bean.PotenFunction;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;

/**
 * IPotenFunctionService
 * @author linych
 * @version 1.0
 *
 */
public interface IPotenFunctionService {

    /**
     * 新增势函数
     * @param function
     */
    public boolean addFunction(PotenFunction function);

    /**
     * 根据id删除势函数,删除前会校验是否有原子势使用到了该函数
     * @param functionId
     */
    public boolean deleteFunctionById(String functionId);
    
    /**
     * 根据id删除函数的参数，删除前会校验是否有原子势使用到了该参数
     * @param paramId
     */
    public boolean deleteFunParamById(String paramId);
    
    /**
     * 获取全部函数
     * @return
     */
    public List<TPotentialsFunction> getAllFunction();

    /**
     * 根据id获取函数
     * @return
     * @param functionId 函数id
     */
    public TPotentialsFunction selectById(String functionId);
    
    /**
     * 更新函数信息
     * @param function
     */
    public void updateFunction(TPotentialsFunction function);
}
