package com.ustb.ssjgl.main.dao.impl;

import java.util.List;

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
        return this.getSqlSession().selectOne(statement, name);
    }

    @Override
    public TElement getElementBySymbol(String symbol) {
        String statement = mapperNamespace + ".selectElementBySymbol";
        return this.getSqlSession().selectOne(statement, symbol);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.IElementDao#selectByCombId(java.lang.String)
     */
    @Override
    public List<TElement> selectByCombId(String combId) {
        String statement = mapperNamespace + ".selectByCombId";
        return this.getSqlSession().selectList(statement, combId);
    }

    @Override
    public List<TElement> getAllElements() {
        String statement = mapperNamespace + ".selectAll";
        return this.getSqlSession().selectList(statement);
    }

    @Override
    public List<String> getElementNamesHasPoten() {
        String statement = mapperNamespace + ".getElementNamesHasPoten";
        return this.getSqlSession().selectList(statement);
    }
}
