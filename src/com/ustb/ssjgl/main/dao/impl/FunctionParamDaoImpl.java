package com.ustb.ssjgl.main.dao.impl;

import java.util.List;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.main.dao.IFunctionParamDao;
import com.ustb.ssjgl.main.dao.bean.TFunctionParam;

/**
 * FunctionParamDaoImpl
 * @author linych
 * @version 1.0
 *
 */
public class FunctionParamDaoImpl extends AbstractDao implements IFunctionParamDao {

    private String mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.TFunctionParamMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.";
    }
    
    
    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.IFunctionParamDao#getFunParamsByFunctionId(java.lang.String)
     */
    @Override
    public List<TFunctionParam> getFunParamsByFunctionId(String funId) {
        String statement = mapperNamespace + ".selectParamsByFunId";
        List<TFunctionParam> params = this.getSqlSession().selectList(statement, funId);
        return params;
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.IFunctionParamDao#addFunParam(com.ustb.ssjgl.main.dao.bean.TFunctionParam)
     */
    @Override
    public void addFunParam(TFunctionParam funParam) {
        insertSelective(funParam);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.IFunctionParamDao#addFunParams(java.util.List)
     */
    @Override
    public void addFunParams(List<TFunctionParam> functionParams) {
        String statement = mapperNamespace + ".batchInsert";
        this.getSqlSession().insert(statement, functionParams);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.IFunctionParamDao#deleteParamsByFunctionId(java.lang.String)
     */
    @Override
    public void deleteParamsByFunctionId(String functionId) {
        String statement = mapperNamespace + ".deleteParamsByFunId";
        this.getSqlSession().delete(statement, functionId);
    }
}
