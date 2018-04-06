package com.ustb.ssjgl.login;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.InvalidSessionException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.ustb.ssjgl.login.dao.bean.TPermission;
import com.ustb.ssjgl.login.dao.bean.TRole;
import com.ustb.ssjgl.login.dao.bean.TUser;
import com.ustb.ssjgl.login.service.IUserService;

public class UserRealm extends AuthorizingRealm {
    @Autowired  
    private IUserService userService;  
    /** 
     * 授权查询回调函数, 进行鉴权但缓存中无用户的授权信息时调用 
     */  
    @Override  
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals){  
        //获取当前登录的用户名,等价于(String)principals.fromRealm(this.getName()).iterator().next()  
        String currentUsername = (String)super.getAvailablePrincipal(principals);  
        TUser member = userService.getUserByName(currentUsername);  
        if(member == null){  
            throw new AuthenticationException("msg:用户不存在。");
        }  
        SimpleAuthorizationInfo simpleAuthorInfo = new SimpleAuthorizationInfo();
          
        List<TRole> roleList = userService.getRoleByUserId(member.getcId());
        List<TPermission> permList = userService.getPermissionByUserId(member.getcId());  
          
        if(roleList != null && roleList.size() > 0){  
            for(TRole role : roleList){  
                if(role.getcRole() != null){  
                    simpleAuthorInfo.addRole(role.getcRole());  
                }  
            }  
        }  
          
        if(permList != null && permList.size() > 0){  
            for(TPermission perm : permList){  
                if(perm.getcPermission() != null){  
                    simpleAuthorInfo.addStringPermission(perm.getcPermission());  
                }  
            }  
        }  
        return simpleAuthorInfo;  
          
    }  
  
      
    /** 
     * 认证回调函数, 登录时调用 
     */  
    @Override  
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {  
        //获取基于用户名和密码的令牌  
        //实际上这个authcToken是从LoginController里面currentUser.login(token)传过来的  
        UsernamePasswordToken token = (UsernamePasswordToken)authcToken;  
          
//        Session session = getSession();  
//        String code = (String)session.getAttribute("");//Constants.VALIDATE_CODE);  
//        if (token.getCaptcha() == null || !token.getCaptcha().toUpperCase().equals(code)){  
//            throw new AuthenticationException("msg:验证码错误, 请重试.");  
//        }  
        TUser user = userService.getUserByName(token.getUsername());
        System.out.println(user.getcPhone());
        if(user != null){
            if(user.getnIslock() !=null && user.getnIslock() == 1){  
                throw new AuthenticationException("msg:该已帐号禁止登录.");  
            }
            AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user.getcLoginName(), user.getcPassword(), this.getName());  
            this.setSession("currentUser", user.getcLoginName());
              
            return authcInfo;  
        }  
        return null;  
    }  
      
    /** 
     * 保存登录名 
     */  
    private void setSession(Object key, Object value){  
        Session session = getSession();  
        System.out.println("Session默认超时时间为[" + session.getTimeout() + "]毫秒");  
        if(null != session){  
            session.setAttribute(key, value);  
        }  
    }  
      
    private Session getSession(){  
        try{  
            Subject subject = SecurityUtils.getSubject();  
            Session session = subject.getSession(false);  
            if (session == null){  
                session = subject.getSession();  
            }  
            if (session != null){  
                return session;  
            }  
        }catch (InvalidSessionException e){  
              
        }  
        return null;  
    }  
}
