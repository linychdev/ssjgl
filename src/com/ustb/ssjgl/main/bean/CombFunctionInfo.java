package com.ustb.ssjgl.main.bean;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ustb.ssjgl.common.utils.JsonUtils;
import com.ustb.ssjgl.main.dao.bean.TCombFunction;
import com.ustb.ssjgl.main.dao.bean.TCombParam;

/**
 * InteratomicPotentials
 * @author linych
 * @version 1.0
 *
 */
public class CombFunctionInfo {
    
    private List<TCombFunction> combFunctions = Lists.newArrayList();

    private List<TCombParam> combParams = Lists.newArrayList();

    public CombFunctionInfo() {
        super();
    }
    /**
     * @param combFunctionJson
     */
    public CombFunctionInfo(JSONObject combFunctionJson) {
        super();
        //设置元素组合函数
        setCombFunctions(combFunctionJson);
    }

    private void setCombFunctions(JSONObject jasonObject) {
        JSONArray functions = JsonUtils.getJSONArrayFromJson(jasonObject, "functions");
        if (functions != null) {
            int order = 1;
            for (Object obj : functions) {
                //设置元素组合函数桥表
                JSONObject functionJson = (JSONObject) obj;
                String functionId = JsonUtils.getStrFromJson(functionJson, "functionId");
                String combId = JsonUtils.getStrFromJson(functionJson, "combId");
                TCombFunction combFunction = new TCombFunction();
                combFunction.setcElementCombId(combId);
                combFunction.setcPotentialsFunctionId(functionId);
                combFunction.setnOrder(order);
                combFunctions.add(combFunction);
                order++;
                //设置函数的参数信息
                setCombParams(functionJson, combFunction);
            }
        }
    }

    private void setCombParams(JSONObject functionJson, TCombFunction function) {
        JSONArray params = JsonUtils.getJSONArrayFromJson(functionJson, "params");
        for (Object paramObj : params) {
            JSONObject param = (JSONObject) paramObj;
            String paramId = JsonUtils.getStrFromJson(param, "paramId");
            String paramClass = JsonUtils.getStrFromJson(param, "paramClass");
            String paramValue = JsonUtils.getStrFromJson(param, "paramValue");

            TCombParam combParam = new TCombParam();
            combParam.setcClass(paramClass);
            combParam.setcElementCombId(function.getcElementCombId());
            combParam.setcParamId(paramId);
            combParam.setcPotentialsFunctionId(function.getcPotentialsFunctionId());
            combParam.setcValue(paramValue);

            combParams.add(combParam);
        }
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
}
