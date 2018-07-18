package com.ustb.ssjgl.main.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.main.dao.IElementCombDao;
import com.ustb.ssjgl.main.dao.bean.TElement;
import com.ustb.ssjgl.main.dao.bean.TElementCombination;

public class ElementCombDaoImpl extends AbstractDao implements IElementCombDao {

    private String mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.TElementCombinationMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.";
    }
    
    @Override
    public TElementCombination getElementCombByName(String name) {
        String statement = mapperNamespace + ".selectByName";
        return this.getSqlSession().selectOne(statement, name);
    }

    @Override
    public List<TElementCombination> getElementCombsByTag(String tag) {
        String statement = mapperNamespace + ".selectByTag";
        return this.getSqlSession().selectList(statement, tag);
    }

    @Override
    public List<TElementCombination> getAllElementCombs() {
        String statement = mapperNamespace + ".selectAllCombs";
        return this.getSqlSession().selectList(statement);
    }

    @Override
    public List<TElementCombination> getElementCombsByElement(TElement element) {
        String statement = mapperNamespace + ".selectByeEementId";
        return this.getSqlSession().selectList(statement);
    }

    @Override
    public void addElementComb(TElementCombination elementComb) {
        insertSelective(elementComb);
    }

    @Override
    public int getCount(@Param("filter") Map<String, Object> filter) {
        String statement = mapperNamespace + ".selectCountByFilter";
        return this.getSqlSession().selectOne(statement, filter);
    }

    @Override
    public List<TElementCombination> getElementCombsByFilter(@Param("filter") Map<String, Object> filter) {
        String statement = mapperNamespace + ".selectByFilter";
        return this.getSqlSession().selectList(statement, filter);
    }

    @Override
    public int getCountNum() {
        String statement = mapperNamespace + ".selectCountNum";
        return this.getSqlSession().selectOne(statement);
    }

    @Override
    public List<Map<String, Integer>> getPotenGroup() {
        String statement = mapperNamespace + ".selectPotenGroup";
        return this.getSqlSession().selectList(statement);
    }

    @Override
    public List<Map<String, Object>> getAllCombMap() {
        String statement = mapperNamespace + ".selectAllCombMap";
        return this.getSqlSession().selectList(statement);
    }

}
