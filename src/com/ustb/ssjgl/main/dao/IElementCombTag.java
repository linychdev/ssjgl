package com.ustb.ssjgl.main.dao;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TElementCombTag;

public interface IElementCombTag extends IAbstractDao {
    
    /**
     * 新增元素组合标签
     * @param tag
     */
    public void addElementCombTag(TElementCombTag tag);
}
