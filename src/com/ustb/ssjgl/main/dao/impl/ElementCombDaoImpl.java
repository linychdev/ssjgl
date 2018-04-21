package com.ustb.ssjgl.main.dao.impl;

import java.util.List;

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

}
