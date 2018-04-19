/*
 * @(#)PotentialsFunctionServiceImpl.java 2018年4月19日上午10:43:18
 * ssjgl
 * Copyright 2018 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ustb.ssjgl.main.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.main.bean.PotenFunction;
import com.ustb.ssjgl.main.dao.ICombFunctionDao;
import com.ustb.ssjgl.main.dao.ICombParamDao;
import com.ustb.ssjgl.main.dao.IFunctionParamDao;
import com.ustb.ssjgl.main.dao.IPotentialsFunctionDao;
import com.ustb.ssjgl.main.dao.bean.TFunctionParam;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;
import com.ustb.ssjgl.main.service.IPotentialsFunctionService;

/**
 * PotentialsFunctionServiceImpl
 * @author linych
 * @version 1.0
 *
 */
public class PotentialsFunctionServiceImpl implements IPotentialsFunctionService{

    private static final Logger LOG = LogUtils.getLogger();
    
    @Autowired
    private IPotentialsFunctionDao potentialsFunctionDao;
    
    @Autowired
    private IFunctionParamDao functionParamDao;
    
    @Autowired
    private ICombFunctionDao combFunctionDao;
    
    @Autowired
    private ICombParamDao combParamDao;
    
    
    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IPotentialsFunctionService#addFunction(com.ustb.ssjgl.main.bean.PotenFunction)
     */
    @Transactional
    @Override
    public boolean addFunction(PotenFunction function) {
        try {
            potentialsFunctionDao.addFunction(function.getPotenFunction());
            functionParamDao.addFunParams(function.getFunctionParams());
            return true;
        } catch (Exception e) {
            LOG.error("新增函数及参数出错！", e);
            return false;
        }
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IPotentialsFunctionService#deleteFunctionById(java.lang.String)
     */
    @Transactional
    @Override
    public boolean deleteFunctionById(String functionId) {
        try {
            boolean functionUsed = combFunctionDao.isFunctionUsed(functionId);
            if(functionUsed){
                LOG.warn("函数被引用，不能删除！函数id:{}", functionId);
                return false;
            }
            potentialsFunctionDao.deleteByPrimaryKey(TPotentialsFunction.class, functionId);
            functionParamDao.deleteParamsByFunctionId(functionId);
            return true;
        } catch (Exception e) {
            LOG.error("删除函数及参数出错！", e);
            return false;
        }
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IPotentialsFunctionService#deleteFunParamById(java.lang.String)
     */
    @Transactional
    @Override
    public boolean deleteFunParamById(String paramId) {
        try {
            boolean paramUsed = combParamDao.isParamUsed(paramId);
            if(paramUsed){
                LOG.warn("参数被引用，不能删除！参数id:{}", paramId);
                return false;
            }
            functionParamDao.deleteByPrimaryKey(TFunctionParam.class, paramId);
            return true;
        } catch (Exception e) {
            LOG.error("删除函数的参数失败！参数id:{}", paramId, e);
            return false;
        }
    }
}
