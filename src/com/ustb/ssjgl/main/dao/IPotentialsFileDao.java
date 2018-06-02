package com.ustb.ssjgl.main.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;

public interface IPotentialsFileDao extends IAbstractDao{
    
    /**
     * 新增势数据文件(元数据)
     * @param ptenFile
     */
    public void addPotentialsFile(TPotentialsFile ptenFile);
    
    /**
     * 根据id删除势数据文件元数据
     * @param id
     */
    public void deletePotentialsFileById(String id);

    /**
     * 根据文献id删除势数据文件元数据
     * @param referenceId
     */
    public void deleteByReferenceId(String referenceId);

    /**
     * 根据文献获取势数据文件
     * @param referenceId
     * @return
     */
    public List<TPotentialsFile> selectByReferenceId(String referenceId);
}
