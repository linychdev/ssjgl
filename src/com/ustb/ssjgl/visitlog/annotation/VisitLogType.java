package com.ustb.ssjgl.visitlog.annotation;

import com.ustb.ssjgl.common.SsjglContants;


public enum VisitLogType {
    
    LOGIN("登录",SsjglContants.VISIT_TYPE_LOGIN),
    LOGOUT("登出",SsjglContants.VISIT_TYPE_LOGOUT),
    SEARCH_COMB("搜索元素组合",SsjglContants.VISIT_TYPE_SEARCH_COMB),
    SEARCH_COMB_LIST("搜索元素组合列表",SsjglContants.VISIT_TYPE_SEARCH_COMB_LIST),
    BROWSE("浏览",SsjglContants.VISIT_TYPE_BROWSE),
    DOWNLOAD("下载",SsjglContants.VISIT_TYPE_DOWNLOAD);
    private final String name;
    private final Integer value;
    
    private VisitLogType(String name, Integer value) {
        this.name = name;
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
