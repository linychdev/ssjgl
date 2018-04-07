package com.ustb.ssjgl.login.action;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ustb.ssjgl.login.dao.bean.TUser;

/**
 * 登录控制器
 * LoginAction
 * @author linych
 * @version 1.0
 *
 */
@Controller
public class LoginAction {
    @RequestMapping("/login")
    public String login(@RequestParam("username") String username,
             @RequestParam("password")String password){
       
        //创建subject实例
        Subject subject = SecurityUtils.getSubject();
        //判断当前用户是否登录
        if(subject.isAuthenticated()==false){
            //将用户名及密码封装交个UsernamePasswordToken
            UsernamePasswordToken token = new UsernamePasswordToken(username,password);
            try {
               subject.login(token);
           } catch (AuthenticationException e) {
               System.out.println("验证不通过，无法登录！");
               return "error";
           }
        }
       return "index";
    }
}
