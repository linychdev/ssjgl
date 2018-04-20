package com.ustb.ssjgl.login.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.ustb.ssjgl.common.MailConfigFile;
import com.ustb.ssjgl.common.utils.CommonUtils;
import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.common.utils.MailUtils;
import com.ustb.ssjgl.login.dao.IEmailRecordDao;
import com.ustb.ssjgl.login.dao.bean.TEmailRecord;
import com.ustb.ssjgl.login.service.IEmailService;

public class EmailServiceImpl implements IEmailService{

    private static final Logger LOG = LogUtils.getLogger();
    
    @Autowired
    private IEmailRecordDao emailRecordDao;
    
    @Override
    public List<String> getValidVerificationCodeByEmail(String emailAddress) {
        return emailRecordDao.getValidVerificationCodeByEmail(emailAddress);
    }

    @Override
    public String sendVerificationMessage(String emailAddress) {
        try {
            String verificationCode = CommonUtils.getVerMessage(MailConfigFile.verCodeLength);
            String html = MailConfigFile.verMessageFormat;
            html = html.replace("verificationCode", verificationCode);
            TEmailRecord emailRecord = new TEmailRecord();
            emailRecord.setcEmail(emailAddress);
            emailRecord.setcVerificationCode(verificationCode);
            emailRecord.setcHtml(html);
            MailUtils.sendMail(emailAddress, MailConfigFile.subject, html);
            emailRecordDao.saveEmailRecord(emailRecord);
            return verificationCode;
        } catch (Exception e) {
            LOG.warn("发送邮件失败！" , e);
            return "faild";
        }
    }
}
