package com.ustb.ssjgl.main.service;

import com.ustb.ssjgl.main.bean.InteratomicPotentials;

/**
 * IElementCombService
 * @author linych
 * @version 1.0
 *
 */
public interface IElementCombService {
    
    /**
     * 新增原子间势
     * @param interatomicPotentials
     */
    public void addInteratomicPotentials(InteratomicPotentials interatomicPotentials);
}
