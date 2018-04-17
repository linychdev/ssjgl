package com.ustb.ssjgl.common.utils;

import org.slf4j.Logger;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class SpringBeanUtils {
    
    private static final Logger LOG = LogUtils.getLogger();
    
    /**
     * 获取spring容器中的bean
     * @param clazz 
     * @param beanId
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> clazz, String beanId){
        try {
            WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
            return (T) wac.getBean(beanId);
        } catch (Exception e) {
            LOG.error("从spring容器中获取bean出错！", e);
            return null;
        }
    }
}
