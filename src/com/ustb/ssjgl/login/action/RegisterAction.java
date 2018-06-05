package com.ustb.ssjgl.login.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ustb.ssjgl.common.action.AbstractAction;
import com.ustb.ssjgl.common.utils.DateUtils;
import com.ustb.ssjgl.login.dao.bean.TUser;
import com.ustb.ssjgl.login.service.IEmailService;
import com.ustb.ssjgl.login.service.ISessionService;
import com.ustb.ssjgl.login.service.IUserService;

/**
 * 注册
 * RegisterAction
 * @author linych
 * @version 1.0
 *
 */
@Controller
public class RegisterAction extends AbstractAction{
    
    @Autowired
    private IUserService userService;
    
    @Autowired
    private IEmailService emailService;

    @Autowired
    private ISessionService sessionService;
    
    @RequestMapping("/register/regist")
    public String register(@RequestParam("username") String username,
            @RequestParam("password") String password, 
            @RequestParam("name") String name,
            @RequestParam("email") String email,
            @RequestParam("phone") String phone,
            @RequestParam("vercode") String vercode){
        
        if(isValidVerCode(email, vercode)){
            TUser user = new TUser();
            user.setcEmail(email);
            user.setcName(name);
            user.setcLoginName(username);
            user.setcPhone(phone);
            String encryptionPassword = getEncryptionPassword(username, password);
            user.setcPassword(encryptionPassword.toString());
            boolean success = userService.addUser(user);
            if(success){
                return "login/login";
            }else{
                return "error";
            }
        }else{
            return "vercodeFaild";
        }
    }

    @RequestMapping("/register/addManagerUser")
    public void addManagerUser(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        
        Map<String, Object> result = new HashMap<String, Object>();
        TUser user = new TUser();
        user.setcEmail(email);
        user.setcName(name);
        user.setcLoginName(userName);
        String password = "123456";
        String encryptionPassword = getEncryptionPassword(userName, password);
        user.setcPassword(encryptionPassword);
        boolean success = userService.addUser(user);
        if(success){
            result.put("success", true);
            result.put("password", password);
        }else{
            result.put("success", false);
            result.put("msg", "添加用户失败！");
        }
        this.writeAjaxObject(response, result);
    }

    @RequestMapping("/register/modifyPassword")
    public void modifyPassword(HttpServletRequest request, HttpServletResponse response){
        String oldPass = request.getParameter("oldpass");
        String newPass = request.getParameter("newpass");
        Map<String, Object> result = new HashMap<String, Object>();
        if(sessionService.isLogin()){
            doModify(oldPass, newPass, result);
        }else{
            result.put("success", false);
            result.put("msg", "请重新登录！");
        }
        this.writeAjaxObject(response, result);
    }

    private void doModify(String oldPass, String newPass,
            Map<String, Object> result) {
        TUser user = sessionService.getCurrentUser();
        if(user.getcPassword().equals(getEncryptionPassword(user.getcLoginName(), oldPass))){
            String encryptionPassword = getEncryptionPassword(user.getcLoginName(), newPass);
            user.setcPassword(encryptionPassword);
            user.setdTime(DateUtils.getCurrentDate());
            userService.modifyPassword(user);
            result.put("success", true);
        }else{
            result.put("success", false);
            result.put("msg", "原始密码错误！");
        }
    }
    
    
    @RequestMapping("/register/sendEmail")
    public void sendEmail(HttpServletRequest request, HttpServletResponse response){
        String emailAddress = request.getParameter("emailAddress");
        Map<String, Object> result = new HashMap<String, Object>();
        //校验邮箱是否已被使用
        TUser user = userService.getUserByEmail(emailAddress);
        if(user != null){
            result.put("emailUsed", true);
        }else{
            emailService.sendVerificationMessage(emailAddress);
            result.put("success", true);
        }
        this.writeAjaxObject(response, result);
    }
    
    @RequestMapping("/register/checkName")
    public void checkName(HttpServletRequest request, HttpServletResponse response){
        String loginName = request.getParameter("loginName");
        Map<String, Object> result = new HashMap<String, Object>();
        //校验用户名是否已被使用
        TUser user = userService.getUserByName(loginName);
        if(user != null){
            result.put("repeat", true);
        }else{
            result.put("repeat", false);
        }
        this.writeAjaxObject(response, result);
    }

    /**
     * 邮件验证码是否正确
     * @param emailAddress
     * @param vercode
     * @return
     */
    private boolean isValidVerCode(String emailAddress, String vercode) {
        List<String> validCodeList = emailService.getValidVerificationCodeByEmail(emailAddress);
        if(validCodeList.contains(vercode)){
            return true;
        }
        return false;
    }

    /**
     * 获取加密后的密码值
     * @param username
     * @param password
     * @return
     */
    private String getEncryptionPassword(String username, String password) {
        String hashAlgorithmName = "MD5";//加密方式  
        Object crdentials = password;//密码原值  
        ByteSource salt = ByteSource.Util.bytes(username);//以账号作为盐值  
        int hashIterations = 1024;//加密1024次  
        SimpleHash encryptionPassword = new SimpleHash(hashAlgorithmName,crdentials,salt,hashIterations);
        return encryptionPassword.toString();
    }
}
