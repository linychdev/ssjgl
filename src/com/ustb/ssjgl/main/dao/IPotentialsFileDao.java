package com.ustb.ssjgl.main.dao;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;

public interface IPotentialsFileDao extends IAbstractDao{
    
    /**
     * 新增势数据文件(元数据)
     * @param ptenFile
     */
    public void addPtentialsFile(TPotentialsFile ptenFile);
    
    /**
     * 根据id删除势数据文件元数据
     * @param id
     */
    public void deletePtentialsFileById(String id);

    /**
     * 根据组合id删除势数据文件元数据
     * @param combName
     */
    public void deleteByCombId(String combId);
}
