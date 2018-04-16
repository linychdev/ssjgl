/*
 * @(#)InteratomicPotentials.java 2018年4月16日下午4:07:48
 * ssjgl
 * Copyright 2018 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ustb.ssjgl.main.bean;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ustb.ssjgl.common.utils.SpringBeanUtils;
import com.ustb.ssjgl.common.utils.SsjglUtils;
import com.ustb.ssjgl.main.dao.IElementDao;
import com.ustb.ssjgl.main.dao.bean.TCombFunction;
import com.ustb.ssjgl.main.dao.bean.TCombParam;
import com.ustb.ssjgl.main.dao.bean.TElement;
import com.ustb.ssjgl.main.dao.bean.TElementCombDetail;
import com.ustb.ssjgl.main.dao.bean.TElementCombTag;
import com.ustb.ssjgl.main.dao.bean.TElementCombination;
import com.ustb.ssjgl.main.dao.bean.TPtentialsFile;

/**
 * InteratomicPotentials
 * @author linych
 * @version 1.0
 *
 */
public class InteratomicPotentials {
    
    private TElementCombination elementComb;
    
    private List<TElementCombDetail> elementCombDetails = Lists.newArrayList();
    
    private List<TElementCombTag> elementCombTags = Lists.newArrayList();
    
    private List<TCombFunction> combFunctions = Lists.newArrayList();
    
    private List<TCombParam> combParams = Lists.newArrayList();
    
    private TPtentialsFile ptentialsFile;

    private IElementDao elementDao = (IElementDao) SpringBeanUtils.getBean("elementDao");
    
    /**
     * @param jasonObject
     */
    public InteratomicPotentials(JSONObject jasonObject) {
        super();
        
        ptentialsFile = new TPtentialsFile();
        //TODO 补齐从json中获取对象信息代码
        
        //设置元素组合信息
        String cCombName = SsjglUtils.getStrFromJson(jasonObject, "combName");
        String cDescription = SsjglUtils.getStrFromJson(jasonObject, "combDescription");
        String cNote = SsjglUtils.getStrFromJson(jasonObject, "combNote");
        String cPtentialsFileId = ptentialsFile.getcId();
        String cReferenceDescription = SsjglUtils.getStrFromJson(jasonObject, "combReferenceDesc");
        elementComb = new TElementCombination();
        elementComb.setcCombName(cCombName);
        elementComb.setcDescription(cDescription);
        elementComb.setcNote(cNote);
        elementComb.setcPtentialsFileId(cPtentialsFileId);
        elementComb.setcReferenceDescription(cReferenceDescription);

        //设置上传势数据文件的部分信息
        String cFileName = SsjglUtils.getStrFromJson(jasonObject, "uploadFileName");
        ptentialsFile.setcFileName(cFileName);
        ptentialsFile.setcElementCombId(elementComb.getcId());
        
        //设置元素组合详情数据信息
        JSONArray combDetails = SsjglUtils.getJSONArrayFromJson(jasonObject, "combDetails");
        if(combDetails != null){
            int order = 1;
            for (Object obj : combDetails) {
                JSONObject detail = (JSONObject)obj;
                String elementId = SsjglUtils.getStrFromJson(detail, "elementId");
                
                TElementCombDetail combDetail = new TElementCombDetail();
                combDetail.setcElementId(elementId);
                combDetail.setcElementCombId(elementComb.getcId());
                combDetail.setnOrder(order);
                elementCombDetails.add(combDetail);
                order++;
            }
        }
        
        
        //TODO 需要确认标签组合是全排列还是组合
        List<TElement> elements = Lists.newArrayList();
        for (TElementCombDetail combDetail : elementCombDetails) {
            TElement element = elementDao.getElementById(combDetail.getcElementId());
            elements.add(element);
//            TElementCombTag combTag = new TElementCombTag();
//            combTag.setcElementCombId(elementComb.getcId());
//            combTag.setcTag(cTag);
        }
        
        for (TElement element : elements) {
            
        }
        
    }

    /**
     * @return the elementComb
     */
    public TElementCombination getElementComb() {
        return elementComb;
    }

    /**
     * @param elementComb the elementComb to set
     */
    public void setElementComb(TElementCombination elementComb) {
        this.elementComb = elementComb;
    }

    /**
     * @return the elementCombDetails
     */
    public List<TElementCombDetail> getElementCombDetails() {
        return elementCombDetails;
    }

    /**
     * @param elementCombDetails the elementCombDetails to set
     */
    public void setElementCombDetails(List<TElementCombDetail> elementCombDetails) {
        this.elementCombDetails = elementCombDetails;
    }

    /**
     * @return the elementCombTags
     */
    public List<TElementCombTag> getElementCombTags() {
        return elementCombTags;
    }

    /**
     * @param elementCombTags the elementCombTags to set
     */
    public void setElementCombTags(List<TElementCombTag> elementCombTags) {
        this.elementCombTags = elementCombTags;
    }

    /**
     * @return the combFunctions
     */
    public List<TCombFunction> getCombFunctions() {
        return combFunctions;
    }

    /**
     * @param combFunctions the combFunctions to set
     */
    public void setCombFunctions(List<TCombFunction> combFunctions) {
        this.combFunctions = combFunctions;
    }

    /**
     * @return the combParams
     */
    public List<TCombParam> getCombParams() {
        return combParams;
    }

    /**
     * @param combParams the combParams to set
     */
    public void setCombParams(List<TCombParam> combParams) {
        this.combParams = combParams;
    }

    /**
     * @return the ptentialsFile
     */
    public TPtentialsFile getPtentialsFile() {
        return ptentialsFile;
    }

    /**
     * @param ptentialsFile the ptentialsFile to set
     */
    public void setPtentialsFile(TPtentialsFile ptentialsFile) {
        this.ptentialsFile = ptentialsFile;
    }
}
