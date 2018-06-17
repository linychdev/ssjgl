package com.ustb.ssjgl.main.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.commons.math3.stat.descriptive.moment.Mean;
import org.apache.commons.math3.stat.descriptive.moment.StandardDeviation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import com.google.common.collect.Lists;
import com.ustb.ssjgl.common.paging.Page;
import com.ustb.ssjgl.login.dao.IUserDao;
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
import com.ustb.ssjgl.main.dao.IPotentialsScopeDao;
import com.ustb.ssjgl.main.dao.IReferenceDao;
import com.ustb.ssjgl.main.dao.bean.ElementCombShowInfo;
import com.ustb.ssjgl.main.dao.bean.TElement;
import com.ustb.ssjgl.main.dao.bean.TElementCombDetail;
import com.ustb.ssjgl.main.dao.bean.TElementCombTag;
import com.ustb.ssjgl.main.dao.bean.TElementCombination;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;
import com.ustb.ssjgl.main.dao.bean.TPotentialsScope;
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
    private IPotentialsScopeDao potentialsScopeDao;
    
    @Autowired
    private IReferenceDao referenceDao;
    
    @Autowired
    private IUserDao userDao;
    
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
        combFunctionDao.addCombFunctions(interPoten.getCombFunctions());
    }

    /**
     * (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#deletePotentialsById(java.lang.String)
     */
    @Transactional
    @Override
    public void deletePotentialsById(String combId) {
        potentialsFileDao.deleteByReferenceId(combId);
//        combParamDao.deleteByCombId(combId);
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
//        combParamDao.addCombParams(combFunInfo.getCombParams());
    }

    /**
     * (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#addPotentialsFile(com.ustb.ssjgl.main.dao.bean.TPotentialsFile)
     */
    @Override
    public void addPotentialsFile(TPotentialsFile potentialsFile) {
        potentialsFileDao.addPotentialsFile(potentialsFile);
    }

    /**
     * (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#deletePotenFileByPotenId(java.lang.String)
     */
    @Override
    public void deletePotenFileByPotenId(String combId) {
        //ftp服务器上的文件不删除，有同名，覆盖即可
        potentialsFileDao.deleteByReferenceId(combId);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#getPotentialsFileMetaByRefId(java.lang.String)
     */
    @Override
    public List<TPotentialsFile> getPotentialsFileMetaByRefId(String refId) {
        return potentialsFileDao.selectByReferenceId(refId);
    }

    /**
     * (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#getInterPotenListByCombId(java.lang.String)
     */
    @Override
    public InteratomicPotentials getInterPotenByCombId(String id) {
        TElementCombination elementComb = elementCombDao.selectByPrimaryKey(TElementCombination.class, id);
        List<TElementCombDetail> combDetails = elementCombDetailDao.selectByCombId(elementComb.getcId());
        List<TElementCombTag> elementCombTags = elementCombTagDao.selectByCombId(elementComb.getcId());
        List<TPotentialsFunction> potenFunctions = potentialsFunctionDao.selectByCombId(elementComb.getcId());
        List<TReference> references = referenceDao.selectByCombId(elementComb.getcId());
        List<TElement> elementList = elementDao.selectByCombId(elementComb.getcId());
        List<TReferenceInfo> referenceInfos = Lists.newArrayList();
        
        for (TReference reference : references) {
            List<TPotentialsFile> potenFiles = potentialsFileDao.selectByReferenceId(reference.getcId());
            TReferenceInfo refInfo = new TReferenceInfo();
            refInfo.setReference(reference);
            refInfo.setPotentialsFiles(potenFiles);
            referenceInfos.add(refInfo);
        }
        
        InteratomicPotentials interPoten = new InteratomicPotentials();
        interPoten.setElementComb(elementComb);
        interPoten.setElementCombDetails(combDetails);
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
            //TODO 查询搜索记录表,设置有效搜索次数
            double searchTimes = 0.0;
            elementCombShowInfo.setSearchTimes(searchTimes);
            List<TElement> elementList = elementDao.selectByCombId(elementComb.getcId());
            TPotentialsScope scope = potentialsScopeDao.selectByPrimaryKey(TPotentialsScope.class, elementComb.getcScopeId());
            elementCombShowInfo.setElementComb(elementComb);
            elementCombShowInfo.setElementList(elementList);
            elementCombShowInfo.setScope(scope);
            elementCombShowInfos.add(elementCombShowInfo);
        }
        setWordCloudFontSize(elementCombShowInfos);
        return elementCombShowInfos;
    }

    @Override
    public TPotentialsFile getPotentialsFileMetaById(String potentialsFileId) {
        return potentialsFileDao.selectByPrimaryKey(TPotentialsFile.class, potentialsFileId);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#saveOrUpdateReference(com.ustb.ssjgl.main.dao.bean.TReference)
     */
    @Override
    public void saveOrUpdateReference(TReference ref) {
        TReference existsRef = referenceDao.selectByPrimaryKey(TReference.class, ref.getcId());
        if(existsRef == null){
            referenceDao.insertSelective(ref);
        }else{
            referenceDao.updateSelective(ref);
        }
    }
    
    /**
     * 设置词云的字体大小
     * @param combList
     */
    private void setWordCloudFontSize(List<ElementCombShowInfo> combList) {
        double[] searchTimes = new double[combList.size()];
        for (int i = 0; i < combList.size(); i++) {
            ElementCombShowInfo combInfo = combList.get(i);
            searchTimes[i] = combInfo.getSearchTimes();
        }
        //计算avg(平均数)
        Mean mean = new Mean(); // 算术平均值
        double avg = mean.evaluate(searchTimes);
        
        //计算stddev(标准差)
        StandardDeviation stdDev =new StandardDeviation();//apache.commons.math3 标准差  
        double sd = stdDev.evaluate(searchTimes);
        
        for (ElementCombShowInfo combInfo : combList) {
            Double times = combInfo.getSearchTimes();
            if(sd == 0){
                combInfo.setSearchTimes(0.0);
            }else{
                double val = (times - avg) / sd;
                combInfo.setSearchTimes(val);
            }
        }
    }

    @Override
    public Page<?> getShowInfoListByPaging(Map<String, Object> filter, int pageSize, int pageIndex) {
        Page<ElementCombShowInfo> page = new Page<ElementCombShowInfo>();
        page.setPageSize(pageSize);
        page.setPageIndex(pageIndex);
        int count = elementCombDao.getCount(filter);
        page.setRecord(count);
        
        filter.put("stratRow", page.getSartRow());
        filter.put("endRow", page.getEndRow());
        List<ElementCombShowInfo> elementCombShowInfos = Lists.newArrayList();
        List<TElementCombination> elementCombs = elementCombDao.getElementCombsByFilter(filter);
        for (TElementCombination elementComb : elementCombs) {
            ElementCombShowInfo elementCombShowInfo = new ElementCombShowInfo();
            List<TElement> elementList = elementDao.selectByCombId(elementComb.getcId());
            TPotentialsScope scope = potentialsScopeDao.selectByPrimaryKey(TPotentialsScope.class, elementComb.getcScopeId());
            elementCombShowInfo.setElementComb(elementComb);
            elementCombShowInfo.setElementList(elementList);
            elementCombShowInfo.setScope(scope);
            elementCombShowInfos.add(elementCombShowInfo);
        }
        page.setDataList(elementCombShowInfos);
        return page;
    }

    @Override
    public List<TElement> getAllElements() {
        
        return elementDao.getAllElements();
    }

    @Override
    public List<TPotentialsFunction> getAllFunction() {
        return potentialsFunctionDao.selectAll();
    }

    @Override
    public TElement getElementBySymbol(String name) {
        return elementDao.getElementBySymbol(name);
    }

    @Override
    public void deleteCombById(String combId) {
        elementCombDao.deleteByPrimaryKey(TElementCombination.class, combId);
        
    }

    @Override
    public void deleteCombDetailByCombId(String combId) {
        elementCombDetailDao.deleteDetailByCombId(combId);
        
    }

    @Override
    public void deleteCombTagByCombId(String combId) {
        elementCombTagDao.deleteTagByCombId(combId);
        
    }

    @Override
    public void addCombFunction(String combId, InteratomicPotentials interPoten) {
        combFunctionDao.addCombFunctions(interPoten.getCombFunctions());
    }

    @Override
    public void deleteCombFunctionBycombId(String combId) {
        combFunctionDao.deleteByCombId(combId);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#deleteReferenceById(java.lang.String)
     */
    @Override
    public void deleteReferenceById(String refId) {
        potentialsFileDao.deleteByReferenceId(refId);
        referenceDao.deleteByPrimaryKey(TReference.class, refId);
    }

    /** (non-Javadoc)
     * @see com.ustb.ssjgl.main.service.IInterPotenService#deletePotenFileById(java.lang.String)
     */
    @Override
    public void deletePotenFileById(String fileId) {
        potentialsFileDao.deletePotentialsFileById(fileId);
    }
}
