package com.ustb.ssjgl.main.dao;

import java.util.List;
import java.util.Map;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TElement;
import com.ustb.ssjgl.main.dao.bean.TElementCombination;

public interface IElementCombDao extends IAbstractDao{
    
    /**
     * 根据元素组合名称获取元素组合
     * @param name
     * @return
     */
    public TElementCombination getElementCombByName(String name);
    
    /**
     * 根据标签获取元素组合
     * @param tag
     * @return
     */
    public List<TElementCombination> getElementCombsByTag(String tag);
    
    /**
     * 获取全部元素组合
     * @return
     */
    public List<TElementCombination> getAllElementCombs();

    /**
     * 根据元素获取相关元素组合
     * @param element
     * @return
     */
    public List<TElementCombination> getElementCombsByElement(TElement element);
    
    /**
     * 增加一个新的元素组合
     * @param elementComb
     */
    public void addElementComb(TElementCombination elementComb);
    
    /**
     * 根据过滤条件获取总记录数
     * @param filter
     * @return
     */
    public int getCount(Map<String, Object> filter);

    /**
     * 根据过滤条件获取元素组合
     * @param filter
     * @return
     */
    public List<TElementCombination> getElementCombsByFilter(Map<String, Object> filter);
    
}
