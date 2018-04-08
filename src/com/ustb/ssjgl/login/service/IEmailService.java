package com.ustb.ssjgl.login.service;

import java.util.List;

/**
 * 邮件业务逻辑处理
 * IEmailService
 * @author linych
 * @version 1.0
 *
 */
public interface IEmailService {
    
    /**
     * 根据邮箱地址获取有效的验证码串
     * @param email
     * @return
     */
    public List<String> getValidVerificationCodeByEmail(String emailAddress);
    
    /**
     * 发送验证消息邮件
     * @param email
     * @return 返回随机生成的验证码
     */
    public String sendVerificationMessage(String emailAddress);
}
