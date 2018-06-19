package com.ustb.ssjgl.common.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;

/**
 * IPUtils
 * @author linych
 * @version 1.0
 *
 */
public class IPUtils {

    /**
     * Logger
     */
    private static final Logger LOG = LogUtils.getLogger();

    /**
     * 禁止实例化工具类
     */
    private IPUtils() {
        throw new AssertionError("工具类禁止实例化！");
    }

    /**
     * 获取远程访问者的ip地址   ipv4格式
     * @param request 
     * @return ipv4格式的访问者ip
     * 
     */
    public static String getBrowserIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
            if ("0:0:0:0:0:0:0:1%0".equals(ip) || "0:0:0:0:0:0:0:1".equals(ip)) {
                ip = "127.0.0.1";
            }
        }
        return ip;
    }

    /**
     * 获取本机IP地址
     * @return
     * @throws UnknownHostException
     */
    public static String getLocalIpAddress() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            LOG.error("获取服务器IP出错！", e);
        }
        return "";
    }
}
