package com.ustb.ssjgl.common.log.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * VisitLog
 * @author linych
 * @version 1.0
 * 适用于访问统计的注解
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface VisitLog {
    /**
     * 统计类型
     */
    public VisitLogType value();
}
