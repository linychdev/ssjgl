package com.ustb.ssjgl.main.bean;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ustb.ssjgl.common.utils.JsonUtils;
import com.ustb.ssjgl.main.dao.bean.TFunctionParam;
import com.ustb.ssjgl.main.dao.bean.TPotentialsFunction;

/**
 * PotenFunction
 * @author linych
 * @version 1.0
 *
 */
public class PotenFunction {
    
    private TPotentialsFunction potenFunction;
    
    private List<TFunctionParam> functionParams = Lists.newArrayList();
    
    public PotenFunction() {
        super();
    }
    public PotenFunction(JSONObject potenFunctionJson) {
        super();
        //FIXME 函数的参数不做展示，直接提供数据文件，暂时不设置参数信息 2018-05-20
        //设置函数主题信息
        this.potenFunction = setFunction(potenFunctionJson);
        
        //设置函数参数信息
//        setParams(potenFunctionJson, function);
    }
    private void setParams(JSONObject potenFunctionJson, TPotentialsFunction function) {
        JSONArray params = JsonUtils.getJSONArrayFromJson(potenFunctionJson, "functionParams");
        if(params == null){
            return;
        }
        int order = 1;
        for (Object obj : params) {
            JSONObject param = (JSONObject) obj;
            
            String paramName = JsonUtils.getStrFromJson(param, "paramName");
            String paramUnit = JsonUtils.getStrFromJson(param, "paramUnit");
            String paramDesc = JsonUtils.getStrFromJson(param, "paramDesc");

            TFunctionParam functionParam = new TFunctionParam();
            functionParam.setcFunctionId(function.getcId());
            functionParam.setcDescription(paramDesc);
            functionParam.setcName(paramName);
            functionParam.setcUnit(paramUnit);
            functionParam.setnOrder(order);
            functionParams.add(functionParam);
            order++;
        }
    }
    private TPotentialsFunction setFunction(JSONObject potenFunctionJson) {
        String functionName = JsonUtils.getStrFromJson(potenFunctionJson, "functionName");
        String functionFormula = JsonUtils.getStrFromJson(potenFunctionJson, "functionFormula");
        String functionDesc = JsonUtils.getStrFromJson(potenFunctionJson, "functionDesc");
        
        TPotentialsFunction function = new TPotentialsFunction();
        function.setcName(functionName);
        function.setcFormula(functionFormula);
        function.setcDescription(functionDesc);
        this.potenFunction = function;
        return function;
    }

    /**
     * @return the potenFunction
     */
    public TPotentialsFunction getPotenFunction() {
        return potenFunction;
    }

    /**
     * @param potenFunction the potenFunction to set
     */
    public void setPotenFunction(TPotentialsFunction potenFunction) {
        this.potenFunction = potenFunction;
    }

    /**
     * @return the functionParams
     */
    public List<TFunctionParam> getFunctionParams() {
        return functionParams;
    }

    /**
     * @param functionParams the functionParams to set
     */
    public void setFunctionParams(List<TFunctionParam> functionParams) {
        this.functionParams = functionParams;
    }
}
