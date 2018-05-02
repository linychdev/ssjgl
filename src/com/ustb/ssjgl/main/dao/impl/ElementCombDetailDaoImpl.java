package com.ustb.ssjgl.main.dao.impl;

import java.util.List;

import com.ustb.ssjgl.common.dao.AbstractDao;
import com.ustb.ssjgl.main.dao.IElementCombDetailDao;
import com.ustb.ssjgl.main.dao.bean.TElementCombDetail;

public class ElementCombDetailDaoImpl extends AbstractDao implements IElementCombDetailDao {

    private String mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.TElementCombDetailMapper";
    {
        super.mapperNamespace = "com.ustb.ssjgl.main.dao.mappings.";
    }
    
    @Override
    public void addCombDetail(TElementCombDetail combDetail) {
        insertSelective(combDetail);
    }

    @Override
    public void addCombDetails(List<TElementCombDetail> elementCombDetails) {
        String statement = mapperNamespace + ".batchInsert";
        this.getSqlSession().insert(statement, elementCombDetails);
    }

    @Override
    public void deleteDetailByCombId(String combId) {
        String statement = mapperNamespace + ".deleteByCombId";
        this.getSqlSession().delete(statement, combId);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.dao.IElementCombDetailDao#selectByCombId(java.lang.String)
     */
    @Override
    public List<TElementCombDetail> selectByCombId(String combId) {
        String statement = mapperNamespace + ".selectByCombId";
        return this.getSqlSession().selectList(statement, combId);
    }

}
