package com.ustb.ssjgl.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ustb.ssjgl.main.bean.CombFunctionInfo;
import com.ustb.ssjgl.main.bean.InteratomicPotentials;
import com.ustb.ssjgl.main.dao.ICombFunctionDao;
import com.ustb.ssjgl.main.dao.ICombParamDao;
import com.ustb.ssjgl.main.dao.IElementCombDao;
import com.ustb.ssjgl.main.dao.IElementCombDetailDao;
import com.ustb.ssjgl.main.dao.IElementCombTagDao;
import com.ustb.ssjgl.main.dao.IPotentialsFileDao;
import com.ustb.ssjgl.main.dao.bean.TElementCombination;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;
import com.ustb.ssjgl.main.service.IInteratomicPotentialsService;

public class InteratomicPotentialsServiceImpl implements IInteratomicPotentialsService {

    @Autowired
    private IElementCombDao elementCombDao;
    
    @Autowired
    private IElementCombDetailDao elementCombDetailDao;
    
    @Autowired
    private IElementCombTagDao elementCombTagDao;
    
    @Autowired
    private ICombFunctionDao combFunctionDao;
    
    @Autowired
    private ICombParamDao combParamDao;
    
    @Autowired
    private IPotentialsFileDao potentialsFileDao;
    
    @Transactional
    @Override
    public void addInteratomicPotentials(InteratomicPotentials interPoten) {
        TElementCombination elementComb = interPoten.getElementComb();
        if(elementComb == null){
            return;
        }
        elementCombDao.addElementComb(elementComb);
        elementCombDetailDao.addCombDetails(interPoten.getElementCombDetails());
        elementCombTagDao.addElementCombTags(interPoten.getElementCombTags());
    }

    @Transactional
    @Override
    public void deletePotentialsById(String combId) {
        potentialsFileDao.deleteByCombId(combId);
        combParamDao.deleteByCombId(combId);
        combFunctionDao.deleteByCombId(combId);
        elementCombTagDao.deleteTagByCombId(combId);
        elementCombDetailDao.deleteDetailByCombId(combId);
        elementCombDao.deleteByPrimaryKey(TElementCombination.class, combId);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInteratomicPotentialsService#deleteCombFunction(java.lang.String, java.lang.String)
     */
    @Override
    public void deleteCombFunction(String combId, String functionId) {
        combFunctionDao.deleteByCombIdAndFunId(combId,functionId);
    }

    @Transactional
    @Override
    public void addCombFunction(CombFunctionInfo combFunInfo) {
        combFunctionDao.addCombFunctions(combFunInfo.getCombFunctions());
        combParamDao.addCombParams(combFunInfo.getCombParams());
    }

    @Override
    public void addPotentialsFile(TPotentialsFile ptentialsFile) {
        potentialsFileDao.addPtentialsFile(ptentialsFile);
    }

    @Override
    public void deletePotenFileByPotenId(String combId) {
        //ftp服务器上的文件不删除，有同名，覆盖即可
        potentialsFileDao.deleteByCombId(combId);
    }
}
