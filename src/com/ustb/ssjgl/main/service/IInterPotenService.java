package com.ustb.ssjgl.main.service;

import java.util.List;
import java.util.Map;

import com.ustb.ssjgl.common.paging.Page;
import com.ustb.ssjgl.main.bean.CombFunctionInfo;
import com.ustb.ssjgl.main.bean.InteratomicPotentials;
import com.ustb.ssjgl.main.dao.bean.ElementCombShowInfo;
import com.ustb.ssjgl.main.dao.bean.TElement;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;
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
     * @param potentialsFile
     */
    public void addPotentialsFile(TPotentialsFile potentialsFile);

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
     * 删除势文件
     * @param fileId
     */
    public void deletePotenFileById(String fileId);

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
    public void saveOrUpdateReference(TReference ref);
    
    /**
     * 根据分页和过滤条件获取势数据列表
     * @param filter
     * @param pageSize
     * @param pageIndex
     * @return
     */
    public Page<?> getShowInfoListByPaging(Map<String, Object> filter, int pageSize, int pageIndex);
    
    /**
     * 获取全部元素
     * @return
     */
    public List<TElement> getAllElements();

    /**
     * 获取全部函数
     * @return
     */
    public List<TPotentialsFunction> getAllFunction();
    
    /**
     * 根据元素名称获取元素
     * @param name
     * @return
     */
    public TElement getElementBySymbol(String name);

    /**
     * 根据组合id删除组合
     * @param combId
     */
    public void deleteCombById(String combId);

    /**
     * 根据组合id删除组合详情
     * @param combId
     */
    public void deleteCombDetailByCombId(String combId);

    /**
     * 根据组合id删除标签
     * @param combId
     */
    public void deleteCombTagByCombId(String combId);

    /**
     * 添加函数组合映射
     * @param combId 
     * @param interPoten
     */
    public void addCombFunction(String combId, InteratomicPotentials interPoten);

    /**
     * 根据组合id删除函数组合映射
     * @param combId
     */
    public void deleteCombFunctionBycombId(String combId);

    /**
     * 根据主键删除文献
     * @param refId
     */
    public void deleteReferenceById(String refId);
}
