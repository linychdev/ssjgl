package com.ustb.ssjgl.main.dao;

import java.util.List;

import com.ustb.ssjgl.common.dao.IAbstractDao;
import com.ustb.ssjgl.main.dao.bean.TFunctionParam;

public interface IFunctionParamDao extends IAbstractDao {
    /**
     * 根据函数id获取函数参数列表
     * @param funId
     * @return
     */
    public List<TFunctionParam> getFunParamsByFunctionId(String funId);
    
    /**
     * 新增函数参数
     * @param funParam
     */
    public void addFunParam(TFunctionParam funParam);
    
}
