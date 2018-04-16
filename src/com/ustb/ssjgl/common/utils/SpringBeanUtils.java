package com.ustb.ssjgl.common.utils;

import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

public class SpringBeanUtils {
    /**
     * 获取spring容器中的bean
     * @param beanId
     * @return
     */
    public static Object getBean(String beanId){
        WebApplicationContext wac = ContextLoader.getCurrentWebApplicationContext();
        return wac.getBean(beanId);
    }
}
