package com.ustb.ssjgl.main.bean;

import java.util.HashSet;
import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.ustb.ssjgl.common.SsjglContants;
import com.ustb.ssjgl.common.utils.JsonUtils;
import com.ustb.ssjgl.common.utils.SpringBeanUtils;
import com.ustb.ssjgl.main.dao.IElementDao;
import com.ustb.ssjgl.main.dao.bean.TCombFunction;
import com.ustb.ssjgl.main.dao.bean.TElement;
import com.ustb.ssjgl.main.dao.bean.TElementCombDetail;
import com.ustb.ssjgl.main.dao.bean.TElementCombTag;
import com.ustb.ssjgl.main.dao.bean.TElementCombination;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;

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

    private List<TPotentialsFunction> functions = Lists.newArrayList();

    private List<TElement> elements = Lists.newArrayList();

    private List<TCombFunction> combFunctions = Lists.newArrayList();

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
            combFunctions.add(combfunction);
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
            String nameTag1 = e1.getcElementName();
            addTagList(tagList, symbolTag1);
            addTagList(tagList, nameTag1);

            for (TElement e2 : elements) {
                String symbolTag2 = e2.getcSymbol();
                String nameTag2 = e2.getcElementName();
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
        String cScopeId = JsonUtils.getStrFromJson(jasonObject, "scopeId");
        String cCombName = JsonUtils.getStrFromJson(jasonObject, "combName");
        String cDescription = JsonUtils.getStrFromJson(jasonObject, "combDescription");
        String cNote = JsonUtils.getStrFromJson(jasonObject, "combNote");
        String cReferenceDescription = JsonUtils.getStrFromJson(jasonObject, "combReferenceDesc");
        elementComb = new TElementCombination();
        elementComb.setcScopeId(cScopeId);
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
    public List<TPotentialsFunction> getFunctions() {
        return functions;
    }
    public void setFunctions(List<TPotentialsFunction> functions) {
        this.functions = functions;
    }
    public List<TElement> getElements() {
        return elements;
    }
    public void setElements(List<TElement> elements) {
        this.elements = elements;
    }
    
    private HashSet<TElement> getElementsSet(){
        return Sets.newHashSet(elements);
    }
    
    public String getHoleCombName(){
        String combName = elementComb.getcCombName();
        String[] elementSymbols = combName.split(SsjglContants.TAG_JOINT);
        List<String> elementHoleNames = Lists.newArrayList();
        for (String elemet : elementSymbols) {
            for (TElement e : getElementsSet()) {
                if(e.getcSymbol().equals(elemet)){
                    elementHoleNames.add(e.getcElementName());
                }
            }
        }
        StringBuilder holeNameComb = new StringBuilder();
        for (int i = 0; i < elementHoleNames.size(); i++) {
            holeNameComb.append(elementHoleNames.get(i));
            if(i < elementHoleNames.size() - 1){
                holeNameComb.append(SsjglContants.TAG_JOINT);
            }
        }
        return holeNameComb.toString();
    }
    public List<TCombFunction> getCombFunctions() {
        return combFunctions;
    }
    public void setCombFunctions(List<TCombFunction> combFunctions) {
        this.combFunctions = combFunctions;
    }
}
