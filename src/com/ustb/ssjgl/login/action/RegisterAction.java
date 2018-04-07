package com.ustb.ssjgl.login.action;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ustb.ssjgl.login.dao.bean.TUser;
import com.ustb.ssjgl.login.service.IUserService;

/**
 * 注册
 * RegisterAction
 * @author linych
 * @version 1.0
 *
 */
@Controller
public class RegisterAction {
    
    @Autowired
    private IUserService userService;
    
    @RequestMapping("/register")
    public String register(@RequestParam("username") String username,
            @RequestParam("password") String password, 
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone){
        
        TUser user = new TUser();
        user.setcEmail(email);
        user.setcName(name);
        user.setcLoginName(username);
        user.setcPhone(phone);
        
        
        String hashAlgorithmName = "MD5";//加密方式  
        Object crdentials = password;//密码原值  
        ByteSource salt = ByteSource.Util.bytes(username);//以账号作为盐值  
        int hashIterations = 1024;//加密1024次  
        SimpleHash encryptionPassword = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
        user.setcPassword(encryptionPassword.toString());
        
        boolean success = userService.addUser(user);
        
        if(success){
            return "login";
        }
        return "error";
    }
}
