package com.ustb.ssjgl.main.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TElementCombTag;

public interface IElementCombTagDao extends IAbstractDao {
    
    /**
     * 新增元素组合标签
     * @param tag
     */
    public void addElementCombTag(TElementCombTag tag);

    /**
     * 批量增加元素组合标签
     * @param elementCombTags
     */
    public void addElementCombTags(List<TElementCombTag> elementCombTags);

    /**
     * 根据组合id删除标签
     */
    public void deleteTagByCombId(String combId);
}
