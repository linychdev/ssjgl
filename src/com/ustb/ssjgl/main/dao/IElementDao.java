package com.ustb.ssjgl.main.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TElement;

public interface IElementDao extends IAbstractDao {
    /**
     * 根据id获取元素对象
     * @param id
     * @return
     */
    public TElement getElementById(String id);

    /**
     * 根据元素名称获取元素
     * @param name
     * @return
     */
    public TElement getElementByName(String name);
    
    /**
     * 根据元素符号(简称)获取元素
     * @param symbol
     * @return
     */
    public TElement getElementBySymbol(String symbol);

    /**
     * @param getcId
     * @return
     */
    public List<TElement> selectByCombId(String getcId);

    /**
     * 获取所有元素
     * @return
     */
    public List<TElement> getAllElements();
    
}
