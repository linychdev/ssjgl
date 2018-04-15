package com.ustb.ssjgl.main.dao;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TElementCombDetail;

public interface IElementCombDetailDao extends IAbstractDao{
    
    /**
     * 新增组合详情
     * @param combDetail
     */
    public void addCombDetail(TElementCombDetail combDetail);
}
