package com.ustb.ssjgl.main.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TReference;

/**
 * IReferenceDao
 * @author linych
 * @version 1.0
 *
 */
public interface IReferenceDao extends IAbstractDao {

    /**
     * 根据元素组合查询相关文献列表
     * @param combId
     * @return
     */
    public List<TReference> selectByCombId(String combId);
}
