package com.ustb.ssjgl.main.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.ustb.ssjgl.main.bean.CombFunctionInfo;
import com.ustb.ssjgl.main.bean.InteratomicPotentials;
import com.ustb.ssjgl.main.bean.TReferenceInfo;
import com.ustb.ssjgl.main.dao.ICombFunctionDao;
import com.ustb.ssjgl.main.dao.ICombParamDao;
import com.ustb.ssjgl.main.dao.IElementCombDao;
import com.ustb.ssjgl.main.dao.IElementCombDetailDao;
import com.ustb.ssjgl.main.dao.IElementCombTagDao;
import com.ustb.ssjgl.main.dao.IElementDao;
import com.ustb.ssjgl.main.dao.IPotentialsFileDao;
import com.ustb.ssjgl.main.dao.IPotentialsFunctionDao;
import com.ustb.ssjgl.main.dao.IReferenceDao;
import com.ustb.ssjgl.main.dao.bean.ElementCombShowInfo;
import com.ustb.ssjgl.main.dao.bean.TElement;
import com.ustb.ssjgl.main.dao.bean.TElementCombDetail;
import com.ustb.ssjgl.main.dao.bean.TElementCombTag;
import com.ustb.ssjgl.main.dao.bean.TElementCombination;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;
import com.ustb.ssjgl.main.dao.bean.TReference;
import com.ustb.ssjgl.main.service.IInterPotenService;

public class InterPotenServiceImpl implements IInterPotenService {

    @Autowired
    private IElementDao elementDao;
    
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
    
    @Autowired
    private IPotentialsFunctionDao potentialsFunctionDao;
    
    @Autowired
    private IReferenceDao referenceDao;
    /**
     * (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#addInteratomicPotentials(com.ustb.ssjgl.main.bean.InteratomicPotentials)
     */
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

    /**
     * (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#deletePotentialsById(java.lang.String)
     */
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
     * @see com.ustb.ssjgl.main.service.IInterPotenService#deleteCombFunction(java.lang.String, java.lang.String)
     */
    @Override
    public void deleteCombFunction(String combId, String functionId) {
        combFunctionDao.deleteByCombIdAndFunId(combId,functionId);
    }

    /**
     * (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#addCombFunction(com.ustb.ssjgl.main.bean.CombFunctionInfo)
     */
    @Transactional
    @Override
    public void addCombFunction(CombFunctionInfo combFunInfo) {
        combFunctionDao.addCombFunctions(combFunInfo.getCombFunctions());
        combParamDao.addCombParams(combFunInfo.getCombParams());
    }

    /**
     * (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#addPotentialsFile(com.ustb.ssjgl.main.dao.bean.TPotentialsFile)
     */
    @Override
    public void addPotentialsFile(TPotentialsFile ptentialsFile) {
        potentialsFileDao.addPtentialsFile(ptentialsFile);
    }

    /**
     * (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#deletePotenFileByPotenId(java.lang.String)
     */
    @Override
    public void deletePotenFileByPotenId(String combId) {
        //ftp服务器上的文件不删除，有同名，覆盖即可
        potentialsFileDao.deleteByCombId(combId);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#getPotentialsFileMetaByCombId(java.lang.String)
     */
    @Override
    public List<TPotentialsFile> getPotentialsFileMetaByCombId(String combId) {
        return potentialsFileDao.selectByCombId(combId);
    }

    /**
     * (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#getInterPotenListByCombId(java.lang.String)
     */
    @Override
    public InteratomicPotentials getInterPotenByCombId(String id) {
        TElementCombination elementComb = elementCombDao.selectByPrimaryKey(TElementCombination.class, id);
        List<TElementCombDetail> combDetails = elementCombDetailDao.selectByCombId(elementComb.getcId());
        List<TPotentialsFile> ptentialsFiles = potentialsFileDao.selectByCombId(elementComb.getcId());
        List<TElementCombTag> elementCombTags = elementCombTagDao.selectByCombId(elementComb.getcId());
        List<TPotentialsFunction> potenFunctions = potentialsFunctionDao.selectByCombId(elementComb.getcId());
        List<TReference> references = referenceDao.selectByCombId(elementComb.getcId());
        List<TElement> elementList = elementDao.selectByCombId(elementComb.getcId());
        
        List<TReferenceInfo> referenceInfos = Lists.newArrayList();
        for (TReference reference : references) {
            List<TPotentialsFile> potenFiles = potentialsFileDao.selectByCombId(reference.getcId());
            TReferenceInfo refInfo = new TReferenceInfo();
            refInfo.setReference(reference);
            refInfo.setPotentialsFiles(potenFiles);
            referenceInfos.add(refInfo);
        }
        
        InteratomicPotentials interPoten = new InteratomicPotentials();
        interPoten.setElementComb(elementComb);
        interPoten.setElementCombDetails(combDetails);
        interPoten.setPtentialsFiles(ptentialsFiles);
        interPoten.setElementCombTags(elementCombTags);
        interPoten.setFunctions(potenFunctions);
        interPoten.setReferenceInfos(referenceInfos);
        interPoten.setElements(elementList);
        return interPoten;
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#getElementCombShowInfoListByTag(java.lang.String)
     */
    @Override
    public List<ElementCombShowInfo> getElementCombShowInfoListByTag(String tag) {
        List<ElementCombShowInfo> elementCombShowInfos = Lists.newArrayList();
        List<TElementCombination> elementCombs = elementCombDao.getElementCombsByTag(tag);
        for (TElementCombination elementComb : elementCombs) {
            ElementCombShowInfo elementCombShowInfo = new ElementCombShowInfo();
            List<TElement> elementList = elementDao.selectByCombId(elementComb.getcId());
            elementCombShowInfo.setElementComb(elementComb);
            elementCombShowInfo.setElementList(elementList);
            elementCombShowInfos.add(elementCombShowInfo);
        }
        return elementCombShowInfos;
    }

    @Override
    public TPotentialsFile getPotentialsFileMetaById(String potentialsFileId) {
        return potentialsFileDao.selectByPrimaryKey(TPotentialsFile.class, potentialsFileId);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#addReference(com.ustb.ssjgl.main.dao.bean.TReference)
     */
    @Override
    public void addReference(TReference ref) {
        referenceDao.insertSelective(ref);
    }
}
