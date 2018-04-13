package com.ustb.ssjgl.common;

import java.io.IOException;
import java.util.Properties;

import org.slf4j.Logger;

import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.common.utils.PropertiesUtils;

/**
 * Created by linych on 2018/03/28.
 * 读取资源文件数据
 **/
public class MailConfigFile {
    
    private static final Logger LOG = LogUtils.getLogger();
    private static final String PROPERTIES_DEFAULT = "props/config.properties";
    public static String host;
    public static Integer port;
    public static String userName;
    public static String passWord;
    public static String emailForm;
    public static String timeout;
    public static String personal;
    public static Integer failureTime;
    public static String subject;
    public static Integer verCodeLength;
    public static Properties properties;
    static{
        init();
    }

    /**
     * 初始化
     */
    private static void init() {
        properties = PropertiesUtils.getProperties(PROPERTIES_DEFAULT);
        try{
            host = properties.getProperty("mailHost");
            port = Integer.parseInt(properties.getProperty("mailPort"));
            userName = properties.getProperty("mailUsername");
            passWord = properties.getProperty("mailPassword");
            emailForm = properties.getProperty("mailFrom");
            timeout = properties.getProperty("mailTimeout");
            personal = properties.getProperty("mailPersonal");
            subject = new String(properties.getProperty("mailSubject").getBytes("ISO-8859-1"), "utf-8");
            failureTime = Integer.valueOf(properties.getProperty("mailFailureTime"));
            verCodeLength = Integer.valueOf(properties.getProperty("mailVerCodeLength"));
        } catch(IOException e){
            LOG.error("读取配置文件出错！", e);
        }
    }
}