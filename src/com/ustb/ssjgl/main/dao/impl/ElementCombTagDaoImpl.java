package com.ustb.ssjgl.main.dao.impl;

import java.util.List;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.main.dao.IElementCombTagDao;
import com.ustb.ssjgl.main.dao.bean.TElementCombTag;

public class ElementCombTagDaoImpl extends AbstractDao implements IElementCombTagDao {


    private String mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.TElementCombTagMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.";
    }
    
    @Override
    public void addElementCombTag(TElementCombTag tag) {
        insertSelective(tag);
    }

    @Override
    public void addElementCombTags(List<TElementCombTag> elementCombTags) {
        String statement = mapperNamespace + ".batchInsert";
        this.getSqlSession().insert(statement, elementCombTags);
    }

    @Override
    public void deleteTagByCombId(String combId) {
        String statement = mapperNamespace + ".deleteByCombId";
        this.getSqlSession().delete(statement, combId);
    }

}
