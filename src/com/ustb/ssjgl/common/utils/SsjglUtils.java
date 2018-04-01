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
}
