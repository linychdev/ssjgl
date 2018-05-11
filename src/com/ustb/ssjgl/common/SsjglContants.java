package com.ustb.ssjgl.common;

public class SsjglContants {

    
    private SsjglContants() {
        throw new IllegalStateException("Utility class");
      }
    
    /**
     * 用户模块_不锁定用户
     */
    public static final Integer USER_LOCKED = 1;

    /**
     * 用户模块_不锁定用户
     */
    public static final Integer USER_UNLOCKED = 0;

    /**
     * 用户模块_有效
     */
    public static final Integer USER_VALID = 1;

    /**
     * 用户模块_无效
     */
    public static final Integer USER_INVALID = 0;
    
    /**
     * 公共_有效
     */
    public static final Integer COMMON_VALID = 1;

    /**
     * 公共_无效
     */
    public static final Integer COMMON_INVALID = 0;

    /**
     * 标签连接符
     */
    public static final String TAG_JOINT = "-";
    
    /**
     * 匿名账号
     */
    public static final String SSJGL_ANONYMOUS = "ssjglAnonymous";

    /**
     * 超级管理员账号
     */
    public static final String SSJGL_ADMIN = "admin";

    /**
     * 访问类型_登录
     */
    public static final Integer VISIT_TYPE_LOGIN = 1;

    /**
     * 访问类型_登出
     */
    public static final Integer VISIT_TYPE_LOGOUT = 2;

    /**
     * 访问类型_搜索
     */
    public static final Integer VISIT_TYPE_SEARCH = 3;

    /**
     * 访问类型_浏览
     */
    public static final Integer VISIT_TYPE_BROWSE = 4;

    /**
     * 访问类型_下载
     */
    public static final Integer VISIT_TYPE_DOWNLOAD = 5;
    
    /**
     * 参考文献来源_势库
     */
    public static final Integer REFERENCE_SOURCE_SSJGL = 1;

    /**
     * 参考文献来源_其他
     */
    public static final Integer REFERENCE_SOURCE_OTHER = 2;

}
