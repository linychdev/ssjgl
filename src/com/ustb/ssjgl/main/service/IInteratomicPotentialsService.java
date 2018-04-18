package com.ustb.ssjgl.main.service;

import com.ustb.ssjgl.main.bean.InteratomicPotentials;

/**
 * IInteratomicPotentialsService
 * @author linych
 * @version 1.0
 *
 */
public interface IInteratomicPotentialsService {
    
    /**
     * 新增原子间势
     * @param interatomicPotentials
     */
    public void addInteratomicPotentials(InteratomicPotentials interatomicPotentials);

    /**
     * 删除原子间势
     * @param combId
     */
    public void deletePotentialsById(String combId);

    /**
     * 删除元素组合的函数
     * @param combId
     * @param functionId
     */
    public void deleteCombFunction(String combId, String functionId);
}
