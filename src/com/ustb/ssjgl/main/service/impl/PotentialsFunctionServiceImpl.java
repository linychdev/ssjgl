/*
 * @(#)PotentialsFunctionServiceImpl.java 2018年4月19日上午10:43:18
 * ssjgl
 * Copyright 2018 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ustb.ssjgl.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ustb.ssjgl.main.bean.PotenFunction;
import com.ustb.ssjgl.main.dao.IFunctionParamDao;
import com.ustb.ssjgl.main.dao.IPotentialsFunctionDao;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;
import com.ustb.ssjgl.main.service.IPotentialsFunctionService;

/**
 * PotentialsFunctionServiceImpl
 * @author linych
 * @version 1.0
 *
 */
public class PotentialsFunctionServiceImpl implements IPotentialsFunctionService{

    @Autowired
    private IPotentialsFunctionDao potentialsFunctionDao;
    
    @Autowired
    private IFunctionParamDao functionParamDao;
    
    
    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IPotentialsFunctionService#addFunction(com.ustb.ssjgl.main.bean.PotenFunction)
     */
    @Transactional
    @Override
    public void addFunction(PotenFunction function) {
        potentialsFunctionDao.addFunction(function.getPotenFunction());
        functionParamDao.addFunParams(function.getFunctionParams());
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IPotentialsFunctionService#deleteFunctionById(java.lang.String)
     */
    @Override
    public void deleteFunctionById(String functionId) {
        potentialsFunctionDao.deleteByPrimaryKey(TPotentialsFunction.class, functionId);
        functionParamDao.deleteParamsByFunctionId(functionId);
    }
}
