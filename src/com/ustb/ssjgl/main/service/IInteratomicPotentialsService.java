package com.ustb.ssjgl.main.service;

import com.ustb.ssjgl.main.bean.CombFunctionInfo;
import com.ustb.ssjgl.main.bean.InteratomicPotentials;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;

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
     * 新增元素组合函数
     * @param combFunInfo
     */
    public void addCombFunction(CombFunctionInfo combFunInfo);
    
    /**
     * 新增势数据文件元数据
     * @param ptentialsFile
     */
    public void addPotentialsFile(TPotentialsFile ptentialsFile);

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
    
    /**
     * 删除势文件
     * @param pId
     */
    public void deletePotenFileByPotenId(String pId);

    /**
     * @param combId
     * @return
     */
    public TPotentialsFile getPotentialsFileMetaByCombId(String combId);
}
