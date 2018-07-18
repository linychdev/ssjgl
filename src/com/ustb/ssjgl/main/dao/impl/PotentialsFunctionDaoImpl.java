package com.ustb.ssjgl.main.dao.impl;

import java.util.List;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.main.dao.IPotentialsFunctionDao;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;

/**
 * PotentialsFunctionDaoImpl
 * @author linych
 * @version 1.0
 *
 */
public class PotentialsFunctionDaoImpl extends AbstractDao implements IPotentialsFunctionDao {

    private String mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.TPotentialsFunctionMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.";
    }
    
    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.IPotentialsFunctionDao#addFunction(com.ustb.ssjgl.main.dao.bean.TPotentialsFunction)
     */
    @Override
    public void addFunction(TPotentialsFunction function) {
        insertSelective(function);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.IPotentialsFunctionDao#updateFunction(com.ustb.ssjgl.main.dao.bean.TPotentialsFunction)
     */
    @Override
    public void updateFunction(TPotentialsFunction function) {
        update(function);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.IPotentialsFunctionDao#deleteFunction(java.lang.String)
     */
    @Override
    public void deleteFunction(String functionId) {
        deleteByPrimaryKey(TPotentialsFunction.class, functionId);
    }

    @Override
    public List<TPotentialsFunction> selectByCombId(String combId) {
        String statement = mapperNamespace + ".selectByCombId";
        return this.getSqlSession().selectList(statement, combId);
    }

    @Override
    public List<TPotentialsFunction> selectAll() {
        String statement = mapperNamespace + ".selectAll";
        return this.getSqlSession().selectList(statement);
    }

    @Override
    public TPotentialsFunction selectByFunName(String funName) {
        String statement = mapperNamespace + ".selectByFunName";
        return this.getSqlSession().selectOne(statement, funName);
    }

    @Override
    public int selectCountNum() {
        String statement = mapperNamespace + ".selectCountNum";
        return this.getSqlSession().selectOne(statement);
    }
}
