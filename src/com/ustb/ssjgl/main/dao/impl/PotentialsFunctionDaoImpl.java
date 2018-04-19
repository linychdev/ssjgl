package com.ustb.ssjgl.main.dao.impl;

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
}
