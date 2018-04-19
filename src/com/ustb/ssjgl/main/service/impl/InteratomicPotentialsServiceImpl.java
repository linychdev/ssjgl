package com.ustb.ssjgl.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.ustb.ssjgl.main.bean.InteratomicPotentials;
import com.ustb.ssjgl.main.dao.ICombFunctionDao;
import com.ustb.ssjgl.main.dao.ICombParamDao;
import com.ustb.ssjgl.main.dao.IElementCombDao;
import com.ustb.ssjgl.main.dao.IElementCombDetailDao;
import com.ustb.ssjgl.main.dao.IElementCombTagDao;
import com.ustb.ssjgl.main.dao.IPotentialsFileDao;
import com.ustb.ssjgl.main.dao.bean.TElementCombination;
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
        combFunctionDao.addCombFunctions(interPoten.getCombFunctions());
        combParamDao.addCombParams(interPoten.getCombParams());
        
        if(interPoten.getPtentialsFile() != null){
            potentialsFileDao.addPtentialsFile(interPoten.getPtentialsFile());
        }
    }

    @Transactional
    @Override
    public void deletePotentialsById(String combId) {
        potentialsFileDao.deletePtentialsFileByCombId(combId);
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
}
