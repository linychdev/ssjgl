package com.ustb.ssjgl.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;

import org.slf4j.Logger;

/**
 * 资源（文件流）
 * ResourceUtil
 * @author linych
 * @version 1.0
 *
 */
public class ResourceUtils {

    
    private static final Logger LOG = LogUtils.getLogger();
    
    /**
     * @author Rambo
     * @param name
     *            classpath
     * @return
     */
    public static InputStream getResourceAsStream(String name) {
        return Thread.currentThread().getContextClassLoader()
                .getResourceAsStream(name);
    }

    /**
     * @author Rambo
     * @param name
     *            classpath
     * @return
     */
    public static URL getResource(String name) {
        return Thread.currentThread().getContextClassLoader().getResource(name);
    }

    /**
     * 关闭输出流
     */
    public static void close(OutputStream... outputStreams) {
        for (OutputStream outputStream : outputStreams) {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    LOG.error("关闭流出错！", e);
                }
            }
        }
    }
    
    
    /**
     * 关闭输入流
     */
    public static void close(InputStream... inputStreams) {
        for (InputStream inputStream : inputStreams) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    LOG.error("关闭流出错！", e);
                }
            }
        }
    }
    
}