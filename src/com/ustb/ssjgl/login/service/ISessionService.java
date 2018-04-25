package com.ustb.ssjgl.login.service;

import com.ustb.ssjgl.login.dao.bean.TUser;

public interface ISessionService {
    
    /**
     * 是否已经登陆
     * @return
     */
    public Boolean isLogin();
    
    /**
     * 获取当前用户
     * @return
     */
    public TUser getCurrentUser();
    
    /**
     * 是否拥有指定角色
     * @param role
     * @return
     */
    public Boolean hasRole(String role);
    
    /**
     * 是否拥有指定权限
     * @param right
     * @return
     */
    public Boolean hasRight(String right);
    
    /**
     * 注销当前登录用户
     */
    public void logout();
}