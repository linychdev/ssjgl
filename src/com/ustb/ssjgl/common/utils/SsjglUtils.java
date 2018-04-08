package com.ustb.ssjgl.common.utils;

import java.util.UUID;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 势数据管理工具类
 * SsjglUtils
 * @author linych
 * @version 1.0
 *
 */
public class SsjglUtils {
    /**
     * 生成UUID
     * 
     * @param key
     * @return
     */
    public static String getUuid() {
        UUID uuid = UUID.randomUUID();
        byte[] data = DigestUtils.md5(uuid.toString());
        String str = new String(Hex.encodeHex(data, false));
        return str;
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
