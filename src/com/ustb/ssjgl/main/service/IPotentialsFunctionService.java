package com.ustb.ssjgl.main.service;

import com.ustb.ssjgl.main.bean.PotenFunction;

/**
 * IPotentialsFunctionService
 * @author linych
 * @version 1.0
 *
 */
public interface IPotentialsFunctionService {

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
}
