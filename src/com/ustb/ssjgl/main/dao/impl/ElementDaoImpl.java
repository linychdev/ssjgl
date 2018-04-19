package com.ustb.ssjgl.main.dao.impl;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.main.dao.IElementDao;
import com.ustb.ssjgl.main.dao.bean.TElement;

public class ElementDaoImpl extends AbstractDao implements IElementDao {

    private String mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.TElementMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.";
    }
    
    @Override
    public TElement getElementById(String id) {
        return selectByPrimaryKey(TElement.class, id);
    }

    @Override
    public TElement getElementByName(String name) {
        String statement = mapperNamespace + ".selectElementByName";
        TElement element = this.getSqlSession().selectOne(statement, name);
        return element;
    }

    @Override
    public TElement getElementBySymbol(String symbol) {
        String statement = mapperNamespace + ".selectElementBySymbol";
        TElement element = this.getSqlSession().selectOne(statement, symbol);
        return element;
    }
}
