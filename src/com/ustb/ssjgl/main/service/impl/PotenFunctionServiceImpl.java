package com.ustb.ssjgl.main.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.main.bean.PotenFunction;
import com.ustb.ssjgl.main.dao.ICombFunctionDao;
import com.ustb.ssjgl.main.dao.ICombParamDao;
import com.ustb.ssjgl.main.dao.IFunctionParamDao;
import com.ustb.ssjgl.main.dao.IPotentialsFunctionDao;
import com.ustb.ssjgl.main.dao.bean.TFunctionParam;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;
import com.ustb.ssjgl.main.service.IPotenFunctionService;

/**
 * PotenFunctionServiceImpl
 * @author linych
 * @version 1.0
 *
 */
public class PotenFunctionServiceImpl implements IPotenFunctionService{

    private static final Logger LOG = LogUtils.getLogger();
    
    @Autowired
    private IPotentialsFunctionDao potentialsFunctionDao;
    
    @Autowired
    private IFunctionParamDao functionParamDao;
    
    @Autowired
    private ICombFunctionDao combFunctionDao;
    
    @Autowired
    private ICombParamDao combParamDao;
    
    
    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IPotenFunctionService#addFunction(com.ustb.ssjgl.main.bean.PotenFunction)
     */
    @Transactional
    @Override
    public boolean addFunction(PotenFunction function) {
        try {
            potentialsFunctionDao.addFunction(function.getPotenFunction());
            // FIXME 函数暂时没有参数
//            functionParamDao.addFunParams(function.getFunctionParams());
            return true;
        } catch (Exception e) {
            LOG.error("新增函数及参数出错！", e);
            return false;
        }
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IPotenFunctionService#deleteFunctionById(java.lang.String)
     */
    @Transactional
    @Override
    public boolean deleteFunctionById(String functionId) {
        try {
            boolean functionUsed = combFunctionDao.isFunctionUsed(functionId);
            if(functionUsed){
                LOG.warn("函数被引用，不能删除！函数id:{}", functionId);
                return false;
            }
            potentialsFunctionDao.deleteByPrimaryKey(TPotentialsFunction.class, functionId);
            functionParamDao.deleteParamsByFunctionId(functionId);
            return true;
        } catch (Exception e) {
            LOG.error("删除函数及参数出错！", e);
            return false;
        }
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IPotenFunctionService#deleteFunParamById(java.lang.String)
     */
    @Transactional
    @Override
    public boolean deleteFunParamById(String paramId) {
        try {
            boolean paramUsed = combParamDao.isParamUsed(paramId);
            if(paramUsed){
                LOG.warn("参数被引用，不能删除！参数id:{}", paramId);
                return false;
            }
            functionParamDao.deleteByPrimaryKey(TFunctionParam.class, paramId);
            return true;
        } catch (Exception e) {
            LOG.error("删除函数的参数失败！参数id:{}", paramId, e);
            return false;
        }
    }

    @Override
    public List<TPotentialsFunction> getAllFunction() {
        return potentialsFunctionDao.selectAll();
    }

    @Override
    public TPotentialsFunction selectById(String functionId) {
        return potentialsFunctionDao.selectByPrimaryKey(TPotentialsFunction.class, functionId);
    }

    @Override
    public void updateFunction(TPotentialsFunction function) {
        potentialsFunctionDao.update(function);
    }

    @Override
    public TPotentialsFunction selectByName(String funName) {
        return potentialsFunctionDao.selectByFunName(funName);
    }

    @Override
    public int getCountFunctionNum() {
        return potentialsFunctionDao.selectCountNum();
    }
}
