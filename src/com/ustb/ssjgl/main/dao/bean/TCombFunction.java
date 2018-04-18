package com.ustb.ssjgl.main.dao.bean;

import com.ustb.ssjgl.common.utils.SsjglUtils;

public class TCombFunction {
    /** 主键 */
    private String cId;

    /** 元素组合主键 */
    private String cElementCombId;

    /** 势函数主键 */
    private String cPotentialsFunctionId;

    /**
     * 排序字段
     */
    private Integer nOrder;
    
    public TCombFunction() {
        super();
        this.cId = SsjglUtils.getUuid();
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcElementCombId() {
        return cElementCombId;
    }

    public void setcElementCombId(String cElementCombId) {
        this.cElementCombId = cElementCombId == null ? null : cElementCombId.trim();
    }

    public String getcPotentialsFunctionId() {
        return cPotentialsFunctionId;
    }

    public void setcPotentialsFunctionId(String cPotentialsFunctionId) {
        this.cPotentialsFunctionId = cPotentialsFunctionId == null ? null : cPotentialsFunctionId.trim();
    }

    /**
     * @return the nOrder
     */
    public Integer getnOrder() {
        return nOrder;
    }

    /**
     * @param nOrder the nOrder to set
     */
    public void setnOrder(Integer nOrder) {
        this.nOrder = nOrder;
    }
}