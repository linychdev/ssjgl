package com.ustb.ssjgl.main.bean;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ustb.ssjgl.common.SsjglContants;
import com.ustb.ssjgl.common.utils.JsonUtils;
import com.ustb.ssjgl.common.utils.SpringBeanUtils;
import com.ustb.ssjgl.main.dao.IElementDao;
import com.ustb.ssjgl.main.dao.bean.TCombFunction;
import com.ustb.ssjgl.main.dao.bean.TElement;
import com.ustb.ssjgl.main.dao.bean.TElementCombDetail;
import com.ustb.ssjgl.main.dao.bean.TElementCombTag;
import com.ustb.ssjgl.main.dao.bean.TElementCombination;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;
import com.ustb.ssjgl.main.dao.bean.TReference;

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

    private List<TReferenceInfo> referenceInfos = Lists.newArrayList();

    private List<TReference> references = Lists.newArrayList();
    
    private List<TPotentialsFile> ptentialsFiles = Lists.newArrayList();
    
    private List<TPotentialsFunction> functions = Lists.newArrayList();

    private IElementDao elementDao = SpringBeanUtils.getBean(IElementDao.class, "elementDao");

    public InteratomicPotentials() {
        super();
    }
    /**
     * @param interPotenJson
     */
    public InteratomicPotentials(JSONObject interPotenJson) {
        super();
        //设置元素组合信息
        setElementComb(interPotenJson);

        //设置元素组合详情数据信息
        setCombDetails(interPotenJson);

        //设置元素标签
        setCombTags();
        
        //设置函数
        setCombFunctions(interPotenJson);
        
        //设置相关文件
        setReferences(interPotenJson);
    }
    
    /**
     * @param interPotenJson
     */
    private void setReferences(JSONObject interPotenJson) {
        JSONArray referencesJson = JsonUtils.getJSONArrayFromJson(interPotenJson, "references");
        for (Object obj : referencesJson) {
            JSONObject reference = (JSONObject) obj;
            String content = JsonUtils.getStrFromJson(reference, "content");
            String doi = JsonUtils.getStrFromJson(reference, "doi");
            String note = JsonUtils.getStrFromJson(reference, "note");
            TReference ref = new TReference();
            ref.setcElementCombId(elementComb.getcId());
            ref.setcContent(content);
            ref.setcDoi(doi);
            ref.setcNote(note);
            ref.setnSource(SsjglContants.REFERENCE_SOURCE_SSJGL);
            references.add(ref);
        }
    }
    /**
     * @param interPotenJson
     */
    private void setCombFunctions(JSONObject interPotenJson) {
        JSONArray functionsJson = JsonUtils.getJSONArrayFromJson(interPotenJson, "functions");
        for (Object obj : functionsJson) {
            JSONObject function = (JSONObject) obj;
            String functionId = JsonUtils.getStrFromJson(function, "functionId");
            TCombFunction combfunction = new TCombFunction();
            combfunction.setcPotentialsFunctionId(functionId);
            combfunction.setcElementCombId(elementComb.getcId());
        }
    }
    private void setCombTags() {
        //查询出组合元素列表
        List<TElement> elements = Lists.newArrayList();
        for (TElementCombDetail combDetail : elementCombDetails) {
            TElement element = elementDao.getElementById(combDetail.getcElementId());
            elements.add(element);
        }

        //生成元素组合标签
        List<String> tagList = Lists.newArrayList();
        for (TElement e1 : elements) {
            String symbolTag1 = e1.getcSymbol();
            String nameTag1 = e1.getcElmentName();
            addTagList(tagList, symbolTag1);
            addTagList(tagList, nameTag1);

            for (TElement e2 : elements) {
                String symbolTag2 = e2.getcSymbol();
                String nameTag2 = e2.getcElmentName();
                String symbolTag = symbolTag1 + SsjglContants.TAG_JOINT + symbolTag2;
                String nameTag = nameTag1 + SsjglContants.TAG_JOINT + nameTag2;
                addTagList(tagList, symbolTag);
                addTagList(tagList, nameTag);
            }
        }

        for (String tag : tagList) {
            TElementCombTag combTag = new TElementCombTag();
            combTag.setcElementCombId(elementComb.getcId());
            combTag.setcTag(tag);
            elementCombTags.add(combTag);
        }
    }

    private void setCombDetails(JSONObject jasonObject) {
        JSONArray combDetails = JsonUtils.getJSONArrayFromJson(jasonObject, "combDetails");
        if (combDetails != null) {
            int order = 1;
            for (Object obj : combDetails) {
                JSONObject detail = (JSONObject) obj;
                String elementId = JsonUtils.getStrFromJson(detail, "elementId");

                TElementCombDetail combDetail = new TElementCombDetail();
                combDetail.setcElementId(elementId);
                combDetail.setcElementCombId(elementComb.getcId());
                combDetail.setnOrder(order);
                elementCombDetails.add(combDetail);
                order++;
            }
        }
    }

    private void setElementComb(JSONObject jasonObject) {
        String cCombName = JsonUtils.getStrFromJson(jasonObject, "combName");
        String cDescription = JsonUtils.getStrFromJson(jasonObject, "combDescription");
        String cNote = JsonUtils.getStrFromJson(jasonObject, "combNote");
        String cReferenceDescription = JsonUtils.getStrFromJson(jasonObject, "combReferenceDesc");
        elementComb = new TElementCombination();
        elementComb.setcCombName(cCombName);
        elementComb.setcDescription(cDescription);
        elementComb.setcNote(cNote);
        elementComb.setcReferenceDescription(cReferenceDescription);
    }

    private void addTagList(List<String> tagList, String symbolTag1) {
        if (!tagList.contains(symbolTag1)) {
            tagList.add(symbolTag1);
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
    public List<TReferenceInfo> getReferenceInfos() {
        return referenceInfos;
    }
    public void setReferenceInfos(List<TReferenceInfo> referenceInfos) {
        this.referenceInfos = referenceInfos;
    }
    public List<TPotentialsFile> getPtentialsFiles() {
        return ptentialsFiles;
    }
    public void setPtentialsFiles(List<TPotentialsFile> ptentialsFiles) {
        this.ptentialsFiles = ptentialsFiles;
    }
    public List<TPotentialsFunction> getFunctions() {
        return functions;
    }
    public void setFunctions(List<TPotentialsFunction> functions) {
        this.functions = functions;
    }
    /**
     * @return the references
     */
    public List<TReference> getReferences() {
        return references;
    }
    /**
     * @param references the references to set
     */
    public void setReferences(List<TReference> references) {
        this.references = references;
    }
}
