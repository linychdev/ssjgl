package com.ustb.ssjgl.main.bean;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ustb.ssjgl.common.SsjglContants;
import com.ustb.ssjgl.common.utils.JsonUtils;
import com.ustb.ssjgl.common.utils.SpringBeanUtils;
import com.ustb.ssjgl.main.dao.IElementDao;
import com.ustb.ssjgl.main.dao.bean.TElement;
import com.ustb.ssjgl.main.dao.bean.TElementCombDetail;
import com.ustb.ssjgl.main.dao.bean.TElementCombTag;
import com.ustb.ssjgl.main.dao.bean.TElementCombination;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFile;

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

    private List<CombFunParamInfo> combFunParamInfos;

    private TPotentialsFile ptentialsFile;

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
    
    /**
     * @return the ptentialsFile
     */
    public TPotentialsFile getPtentialsFile() {
        return ptentialsFile;
    }

    /**
     * @param ptentialsFile the ptentialsFile to set
     */
    public void setPtentialsFile(TPotentialsFile ptentialsFile) {
        this.ptentialsFile = ptentialsFile;
    }
    /**
     * @return the combFunParamInfos
     */
    public List<CombFunParamInfo> getCombFunParamInfos() {
        return combFunParamInfos;
    }
    /**
     * @param combFunParamInfos the combFunParamInfos to set
     */
    public void setCombFunParamInfos(List<CombFunParamInfo> combFunParamInfos) {
        this.combFunParamInfos = combFunParamInfos;
    }
}
