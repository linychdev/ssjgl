/*
 * @(#)PotenFunction.java 2018年4月18日上午11:04:23
 * ssjgl
 * Copyright 2018 Thuisoft, Inc. All rights reserved.
 * THUNISOFT PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.ustb.ssjgl.main.bean;

import java.util.List;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ustb.ssjgl.common.utils.SsjglUtils;
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
        //设置函数主题信息
        TPotentialsFunction function = setFunction(potenFunctionJson);
        
        //设置函数参数信息
        setParams(potenFunctionJson, function);
    }
    private void setParams(JSONObject potenFunctionJson, TPotentialsFunction function) {
        JSONArray params = SsjglUtils.getJSONArrayFromJson(potenFunctionJson, "functionParams");
        if(params == null){
            return;
        }
        int order = 1;
        for (Object obj : params) {
            JSONObject param = (JSONObject) obj;
            
            String paramName = SsjglUtils.getStrFromJson(param, "paramName");
            String paramUnit = SsjglUtils.getStrFromJson(param, "paramUnit");
            String paramDesc = SsjglUtils.getStrFromJson(param, "paramDesc");

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
        String functionName = SsjglUtils.getStrFromJson(potenFunctionJson, "functionName");
        String functionScopeId = SsjglUtils.getStrFromJson(potenFunctionJson, "functionScopeId");
        String functionFormula = SsjglUtils.getStrFromJson(potenFunctionJson, "functionFormula");
        String functionFormulaHtml = SsjglUtils.getStrFromJson(potenFunctionJson, "functionFormulaHtml");
        String functionDesc = SsjglUtils.getStrFromJson(potenFunctionJson, "functionDesc");
        
        TPotentialsFunction function = new TPotentialsFunction();
        function.setcName(functionName);
        function.setcScopeId(functionScopeId);
        function.setcFormula(functionFormula);
        function.setcFormulaHtml(functionFormulaHtml);
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
