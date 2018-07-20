package com.ustb.ssjgl.login.action;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ustb.ssjgl.common.action.AbstractAction;
import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.login.service.ISessionService;

/**
 * 登录控制器
 * LoginAction
 * @author linych
 * @version 1.0
 *
 */
@Controller
public class LoginAction extends AbstractAction{
    
    private static final Logger LOG = LogUtils.getLogger();
    
    @Autowired
    private ISessionService sessionService;
    
    /**
     * 跳转到登录页面
     * @param request
     * @param response
     */
    @RequestMapping("/login/login")
    @ResponseBody
    public ModelAndView loginIndex(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mode = new ModelAndView();
        mode.setViewName("login/login");
        return mode;
    }
    
    @RequestMapping("/login")
    public void login(HttpServletRequest request, HttpServletResponse response){
       
        String loginName = request.getParameter("loginName");
        String password = request.getParameter("password");
        
        Map<String, Object> result = new HashMap<String, Object>();
        //创建subject实例
        Subject subject = SecurityUtils.getSubject();
        //判断当前用户是否登录
        if(subject.isAuthenticated()==false){
            //将用户名及密码封装交给UsernamePasswordToken
            UsernamePasswordToken token = new UsernamePasswordToken(loginName,password);
            try {
                subject.login(token);
                result.put("success", true);
            } catch (Exception e) {
                LOG.warn("验证不通过，无法登录！", e.getMessage());
                result.put("success", false);
                result.put("msg", "Incorrect username or password!");
            }
        }else{
            result.put("success", true);
        }
       this.writeAjaxObject(response, result);
    }
    
    @RequestMapping("/isLogin")
    public void isLogin(HttpServletRequest request, HttpServletResponse response){
        Map<String, Object> result = new HashMap<String, Object>();
        if(sessionService.isLogin()){
            result.put("isLogin", true);
        }else {
            result.put("isLogin", false);
        }
       this.writeAjaxObject(response, result);
    }
    
    @RequestMapping("/logout")
    public ModelAndView logout(HttpServletRequest request, HttpServletResponse response){
        Subject subject = SecurityUtils.getSubject();
        if(subject.isAuthenticated()==true){
            subject.logout();
        }
        ModelAndView mode = new ModelAndView();
        mode.setViewName("login/login");
        return mode;
    }
}
