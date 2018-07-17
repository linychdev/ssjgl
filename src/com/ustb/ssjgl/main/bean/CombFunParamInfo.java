package com.ustb.ssjgl.main.bean;

import java.util.List;

import com.google.common.collect.Lists;
import com.ustb.ssjgl.main.dao.bean.TCombFunction;
import com.ustb.ssjgl.main.dao.bean.TCombParam;

/**
 * CombFunParamInfo
 * @author linych
 * @version 1.0
 *
 */
public class CombFunParamInfo {
    private TCombFunction combFunction;
    private List<TCombParam> combParams = Lists.newArrayList();
    /**
     * @return the combFunction
     */
    public TCombFunction getCombFunction() {
        return combFunction;
    }
    /**
     * @param combFunction the combFunction to set
     */
    public void setCombFunction(TCombFunction combFunction) {
        this.combFunction = combFunction;
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
