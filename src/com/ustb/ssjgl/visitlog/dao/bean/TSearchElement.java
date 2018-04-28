package com.ustb.ssjgl.visitlog.dao.bean;

import com.ustb.ssjgl.common.utils.UuidUtils;

public class TSearchElement {
    /** 主键 */
    private String cId;

    /** 搜索记录主键 */
    private String cSearchId;

    /** 搜索元素主键 */
    private String cElementId;

    
    public TSearchElement() {
        super();
        this.cId = UuidUtils.getUuid();
    }

    public TSearchElement(String cSearchId) {
        super();
        this.cId = UuidUtils.getUuid();
        this.cSearchId = cSearchId;
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcSearchId() {
        return cSearchId;
    }

    public void setcSearchId(String cSearchId) {
        this.cSearchId = cSearchId == null ? null : cSearchId.trim();
    }

    public String getcElementId() {
        return cElementId;
    }

    public void setcElementId(String cElementId) {
        this.cElementId = cElementId == null ? null : cElementId.trim();
    }
}