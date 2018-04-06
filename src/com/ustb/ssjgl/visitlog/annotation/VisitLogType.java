package com.ustb.ssjgl.visitlog.annotation;


public enum VisitLogType {
    
    SEARCH("搜索",1),
    BROWSE("浏览",2),
    DOWNLOAD("下载",3),
    ;
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
