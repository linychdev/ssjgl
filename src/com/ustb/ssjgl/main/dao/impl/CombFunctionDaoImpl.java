/*
 * @(#)CombFunctionDaoImpl.java 2018年4月19日下午2:35:00
 * ssjgl
 * Copyright 2018 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ustb.ssjgl.main.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.collections.CollectionUtils;

import com.google.common.collect.Maps;
import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.main.dao.ICombFunctionDao;
import com.ustb.ssjgl.main.dao.bean.TCombFunction;

/**
 * CombFunctionDaoImpl
 * @author linych
 * @version 1.0
 *
 */
public class CombFunctionDaoImpl extends AbstractDao implements ICombFunctionDao {

    private String mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.TCombFunctionMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.";
    }
    
    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.ICombFunctionDao#addCombFunction(com.ustb.ssjgl.main.dao.bean.TCombFunction)
     */
    @Override
    public void addCombFunction(TCombFunction combFunction) {
        insertSelective(combFunction);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.ICombFunctionDao#deleteById(java.lang.String)
     */
    @Override
    public void deleteById(String id) {
        deleteByPrimaryKey(TCombFunction.class, id);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.ICombFunctionDao#addCombFunctions(java.util.List)
     */
    @Override
    public void addCombFunctions(List<TCombFunction> combFunctions) {
        String statement = mapperNamespace + ".batchInsert";
        this.getSqlSession().insert(statement, combFunctions);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.ICombFunctionDao#deleteByCombId(java.lang.String)
     */
    @Override
    public void deleteByCombId(String combId) {
        String statement = mapperNamespace + ".deleteByCombId";
        this.getSqlSession().delete(statement, combId);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.ICombFunctionDao#deleteByCombIdAndFunId(java.lang.String, java.lang.String)
     */
    @Override
    public void deleteByCombIdAndFunId(String combId, String functionId) {
        String statement = mapperNamespace + ".deleteByCombIdAndFunId";
        Map<String, String> map = Maps.newHashMap();
        map.put("cElementCombId", combId);
        map.put("cPotentialsFunctionId", functionId);
        this.getSqlSession().delete(statement, map);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.ICombFunctionDao#isFunctionUsed(java.lang.String)
     */
    @Override
    public boolean isFunctionUsed(String functionId) {
        String statement = mapperNamespace + ".selectByFunctionId";
        List<TCombFunction> combFunctionList = this.getSqlSession().selectList(statement, functionId);
        if(CollectionUtils.isEmpty(combFunctionList)){
            return false;
        }
        return true;
    }
}
