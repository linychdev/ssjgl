package com.ustb.ssjgl.main.service;

import java.util.List;

import com.ustb.ssjgl.main.bean.CombFunctionInfo;
import com.ustb.ssjgl.main.bean.InteratomicPotentials;
import com.ustb.ssjgl.main.dao.bean.ElementCombShowInfo;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;
import com.ustb.ssjgl.main.dao.bean.TReference;

/**
 * IInterPotenService
 * @author linych
 * @version 1.0
 *
 */
public interface IInterPotenService {
    
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
     * 根据组合id获取势数据文件
     * @param combId
     * @return
     */
    public List<TPotentialsFile> getPotentialsFileMetaByCombId(String combId);

    /**
     * 根据标签获取势数据信息
     * @param combId
     * @return
     */
    public InteratomicPotentials getInterPotenByCombId(String combId);

    /**
     * 根据标签获取势数据信息
     * @param tag
     * @return
     */
    public List<ElementCombShowInfo> getElementCombShowInfoListByTag(String tag);

    /**
     * 根据主键获取势数据文件
     * @param potentialsFileId
     * @return
     */
    public TPotentialsFile getPotentialsFileMetaById(String potentialsFileId);

    /**
     * 保存文献信息
     * @param ref
     */
    public void addReference(TReference ref);
}
