package com.ustb.ssjgl.common.utils;

import java.io.File;

import org.springframework.web.multipart.MultipartFile;

public class CommonUtils {
    public static String getFileSuffix(File file){
        if(file == null){
            return "";
        }
        String fileName = file.getName();  
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);  
        return suffix;  
    }

    public static String getFileSuffix(MultipartFile file){
        if(file == null){
            return "";
        }
        String fileName = file.getOriginalFilename();  
        String suffix = fileName.substring(fileName.lastIndexOf(".") + 1);  
        return suffix;  
    }
    
    
    public static String getVerMessage(int length) {
        //随机字符串的随机字符库
        String KeyString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuffer sb = new StringBuffer();
        int len = KeyString.length();
        for (int i = 0; i < length; i++) {
            sb.append(KeyString.charAt((int) Math.round(Math.random() * (len - 1))));
        }
        return sb.toString();
    }
}
