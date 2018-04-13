package com.ustb.ssjgl.common.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.Logger;

import com.ustb.ssjgl.common.exception.CommonsException;

/**
 * PropertiesUtil
 * @author linych
 * @version 1.0
 *
 */
public class PropertiesUtils {

    private static final Logger LOG = LogUtils.getLogger();
    
    public static Properties getProperties(String path){
        InputStream stream = ResourceUtils.getResourceAsStream(path);
        Properties p = new Properties();
        try {
            p.load(stream);
            return p;
        } catch (IOException e) {
            LOG.error("读取配置文件:{}出错！", path, e);
            throw new CommonsException(e);
        }finally{
            ResourceUtils.close(stream);
        }
    }
}
