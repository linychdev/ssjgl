package com.ustb.ssjgl.main.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TElementCombDetail;

public interface IElementCombDetailDao extends IAbstractDao{
    
    /**
     * 新增组合详情
     * @param combDetail
     */
    public void addCombDetail(TElementCombDetail combDetail);

    /**
     * 批量插入组合详情
     * @param elementCombDetails
     */
    public void addCombDetails(List<TElementCombDetail> elementCombDetails);

    /**
     * 根据组合id删除组合详情
     * @param combId
     */
    public void deleteDetailByCombId(String combId);
}
