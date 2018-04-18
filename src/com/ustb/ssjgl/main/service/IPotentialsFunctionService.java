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
    public void addFunction(PotenFunction function);

    /**
     * 根据id删除势函数
     * @param functionId
     */
    public void deleteFunctionById(String functionId);
}
