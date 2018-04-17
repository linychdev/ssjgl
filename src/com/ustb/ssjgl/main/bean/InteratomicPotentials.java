package com.ustb.ssjgl.main.bean;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ustb.ssjgl.common.SsjglContants;
import com.ustb.ssjgl.common.utils.SpringBeanUtils;
import com.ustb.ssjgl.common.utils.SsjglUtils;
import com.ustb.ssjgl.main.dao.IElementDao;
import com.ustb.ssjgl.main.dao.bean.TCombFunction;
import com.ustb.ssjgl.main.dao.bean.TCombParam;
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

    private List<TCombFunction> combFunctions = Lists.newArrayList();

    private List<TCombParam> combParams = Lists.newArrayList();

    private TPotentialsFile ptentialsFile;

    private IElementDao elementDao = SpringBeanUtils.getBean(IElementDao.class, "elementDao");

    /**
     * @param interPotenJson
     */
    public InteratomicPotentials(JSONObject interPotenJson) {
        super();
        //设置元素组合信息
        setElementComb(interPotenJson);

        //设置上传势数据文件的部分信息
        setPtentialsFile(interPotenJson);

        //设置元素组合详情数据信息
        setCombDetails(interPotenJson);

        //设置元素组合函数
        setCombFunctions(interPotenJson);

        //设置元素标签
        setCombTags();
    }

    private void setCombFunctions(JSONObject jasonObject) {
        JSONArray functions = SsjglUtils.getJSONArrayFromJson(jasonObject, "functions");
        if (functions != null) {
            int order = 1;
            for (Object obj : functions) {
                //设置元素组合函数桥表
                JSONObject function = (JSONObject) obj;
                String functionId = SsjglUtils.getStrFromJson(function, "functionId");
                TCombFunction combFunction = new TCombFunction();
                combFunction.setcElementCombId(elementComb.getcId());
                combFunction.setcPtentialsFunctionId(functionId);
                combFunction.setnOrder(order);
                combFunctions.add(combFunction);
                order++;
                //设置函数的参数信息
                setCombParams(function, functionId);
            }
        }
    }

    private void setCombParams(JSONObject function, String functionId) {
        JSONArray params = SsjglUtils.getJSONArrayFromJson(function, "params");
        for (Object paramObj : params) {
            JSONObject param = (JSONObject) paramObj;
            String paramId = SsjglUtils.getStrFromJson(param, "paramId");
            String paramClass = SsjglUtils.getStrFromJson(param, "paramClass");
            String paramValue = SsjglUtils.getStrFromJson(param, "paramValue");

            TCombParam combParam = new TCombParam();
            combParam.setcClass(paramClass);
            combParam.setcElementCombId(elementComb.getcId());
            combParam.setcParamId(paramId);
            combParam.setcPtentialsFunctionId(functionId);
            combParam.setcValue(paramValue);

            combParams.add(combParam);
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
        JSONArray combDetails = SsjglUtils.getJSONArrayFromJson(jasonObject, "combDetails");
        if (combDetails != null) {
            int order = 1;
            for (Object obj : combDetails) {
                JSONObject detail = (JSONObject) obj;
                String elementId = SsjglUtils.getStrFromJson(detail, "elementId");

                TElementCombDetail combDetail = new TElementCombDetail();
                combDetail.setcElementId(elementId);
                combDetail.setcElementCombId(elementComb.getcId());
                combDetail.setnOrder(order);
                elementCombDetails.add(combDetail);
                order++;
            }
        }
    }

    private void setPtentialsFile(JSONObject jasonObject) {
        String cFileName = SsjglUtils.getStrFromJson(jasonObject, "uploadFileName");
        ptentialsFile = new TPotentialsFile();
        ptentialsFile.setcFileName(cFileName);
        ptentialsFile.setcElementCombId(elementComb.getcId());
    }

    private void setElementComb(JSONObject jasonObject) {
        String cCombName = SsjglUtils.getStrFromJson(jasonObject, "combName");
        String cDescription = SsjglUtils.getStrFromJson(jasonObject, "combDescription");
        String cNote = SsjglUtils.getStrFromJson(jasonObject, "combNote");
        String cReferenceDescription = SsjglUtils.getStrFromJson(jasonObject, "combReferenceDesc");
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
    public TPotentialsFile getPtentialsFile() {
        return ptentialsFile;
    }

    /**
     * @param ptentialsFile the ptentialsFile to set
     */
    public void setPtentialsFile(TPotentialsFile ptentialsFile) {
        this.ptentialsFile = ptentialsFile;
    }
}
