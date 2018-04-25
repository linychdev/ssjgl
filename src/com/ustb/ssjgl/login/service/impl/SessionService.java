package com.ustb.ssjgl.login.service.impl;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.ustb.ssjgl.common.SsjglContants;
import com.ustb.ssjgl.common.utils.RequestUtils;
import com.ustb.ssjgl.login.dao.bean.TUser;
import com.ustb.ssjgl.login.service.ISessionService;

public class SessionService implements ISessionService {
    
    @Override
    public Boolean isLogin() {
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            TUser user = (TUser)subject.getPrincipal();
            return !StringUtils.equals(user.getcName(), SsjglContants.SSJGL_ANONYMOUS);
        }else{
            return false;
        }
    }

    @Override
    public TUser getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            return (TUser) subject.getSession().getAttribute("currentUser");
        }
        return null;
    }

    @Override
    public Boolean hasRole(String role) {
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            if(isAdmin()){
                return true;
            }
            return subject.hasRole(role);
        }
        return false;
    }
    
    private boolean isAdmin(){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            TUser user= (TUser) subject.getPrincipal();
            return StringUtils.equalsIgnoreCase(SsjglContants.SSJGL_ADMIN, user.getcLoginName());
        }
        return false;
    }

    @Override
    public Boolean hasRight(String right) {
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            if(isAdmin()){
                return true;
            }
            return subject.isPermitted(right);
        }
        return false;
    }

    @Override
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()){
            subject.logout();
        }
        afterLogout();
    }

    //TODO 待完善
    private void afterLogout() {
        HttpServletRequest req = RequestUtils.getRequest();
        req.getSession().removeAttribute("");
    }
}