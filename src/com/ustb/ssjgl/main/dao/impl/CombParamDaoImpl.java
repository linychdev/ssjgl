/*
 * @(#)CombParamDaoImpl.java 2018年4月19日下午5:55:31
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
import com.ustb.ssjgl.main.dao.ICombParamDao;
import com.ustb.ssjgl.main.dao.bean.TCombParam;

/**
 * CombParamDaoImpl
 * @author linych
 * @version 1.0
 *
 */
public class CombParamDaoImpl extends AbstractDao implements ICombParamDao {

    private String mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.TCombParamMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.";
    }
    
    
    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.ICombParamDao#addCombParam(com.ustb.ssjgl.main.dao.bean.TCombParam)
     */
    @Override
    public void addCombParam(TCombParam combParam) {
        insertSelective(combParam);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.ICombParamDao#addCombParams(java.util.List)
     */
    @Override
    public void addCombParams(List<TCombParam> combParamList) {
        String statement = mapperNamespace + ".batchInsert";
        this.getSqlSession().insert(statement, combParamList);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.ICombParamDao#deleteById(java.lang.String)
     */
    @Override
    public void deleteById(String id) {
        deleteByPrimaryKey(TCombParam.class, id);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.ICombParamDao#deleteByCombId(java.lang.String)
     */
    @Override
    public void deleteByCombId(String combId) {
        String statement = mapperNamespace + ".deleteByCombId";
        this.getSqlSession().delete(statement, combId);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.ICombParamDao#deleteByCombIdAndFunId(java.lang.String, java.lang.String)
     */
    @Override
    public void deleteByCombIdAndFunId(String combId, String funId) {
        String statement = mapperNamespace + ".deleteByCombIdAndFunId";
        Map<String, String> map = Maps.newHashMap();
        map.put("cElementCombId", combId);
        map.put("cPotentialsFunctionId", funId);
        this.getSqlSession().delete(statement, map);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.ICombParamDao#isParamUsed(java.lang.String)
     */
    @Override
    public boolean isParamUsed(String paramId) {
        String statement = mapperNamespace + ".selectByParamId";
        List<TCombParam> list = this.getSqlSession().selectList(statement, paramId);
        return CollectionUtils.isNotEmpty(list);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.ICombParamDao#selectByCombIdAndFunId(java.lang.String, java.lang.String)
     */
    @Override
    public List<TCombParam> selectByCombIdAndFunId(String combId, String funId) {
        String statement = mapperNamespace + ".selectByCombIdAndFunId";
        Map<String, String> map = Maps.newHashMap();
        map.put("cElementCombId", combId);
        map.put("cPotentialsFunctionId", funId);
        return this.getSqlSession().selectList(statement, map);
    }
}
