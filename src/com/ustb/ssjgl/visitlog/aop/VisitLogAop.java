package com.ustb.ssjgl.visitlog.aop;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.ustb.ssjgl.common.utils.IPUtils;
import com.ustb.ssjgl.common.utils.LogUtils;
import com.ustb.ssjgl.common.utils.UuidUtils;
import com.ustb.ssjgl.service.IVisitLogService;
import com.ustb.ssjgl.visitlog.annotation.VisitLog;
import com.ustb.ssjgl.visitlog.annotation.VisitLogType;

@Aspect
@Component
public class VisitLogAop {
    private static final Logger LOG = LogUtils.getLogger();

    @Autowired
    IVisitLogService visitLogService;

    HttpServletRequest request = null;

    ThreadLocal<Long> time = new ThreadLocal<Long>();

    //用于生成操作日志的唯一标识，用于业务流程审计日志调用
    public static ThreadLocal<String> tag = new ThreadLocal<String>();

    //声明AOP切入点，凡是使用了VisitLog的方法均被拦截
    @Pointcut("@annotation(com.ustb.ssjgl.visitlog.annotation.VisitLog)")
    public void log() {
        LOG.info("我是一个切入点");
    }

    /**
     * 在所有标注@Log的地方切入
     * @param joinPoint
     */
    @Before("log()")
    public void beforeExec(JoinPoint joinPoint) {
        time.set(System.currentTimeMillis());   
        //设置日志记录的唯一标识号
        tag.set(UuidUtils.getUuid());
        request=  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

    }
    @After("log()")
    public void afterExec(JoinPoint joinPoint) {
        MethodSignature ms = (MethodSignature) joinPoint.getSignature();
        Method method = ms.getMethod();
        LOG.debug("标记为" + tag.get() + "的方法" + method.getName()
                + "运行消耗" + (System.currentTimeMillis() - time.get()) + "ms");   
    }
    //在执行目标方法的过程中，会执行这个方法，可以在这里实现日志的记录
    @Around("log()")
    public Object aroundExec(ProceedingJoinPoint pjp) throws Throwable {
        Object ret = pjp.proceed();
        try {
            Object[] orgs = pjp.getArgs();
            MethodSignature ms = (MethodSignature) pjp.getSignature();
            Method method = ms.getMethod();
            //获取注解的操作日志信息
            VisitLog log = method.getAnnotation(VisitLog.class);
            VisitLogType businessType = log.value();
            LOG.info("客户端IP为:{},执行的操作为:{}", IPUtils.getBrowserIpAddress(request), businessType.getName());
        } catch (Exception e) {
            LOG.error("获取执行方法信息出错！", e);
        }
        return ret;
    }
    //记录异常日志
    @AfterThrowing(pointcut = "log()",throwing="e")
    public  void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
        LOG.error("出错啦！",e);
    }
    
    private void info(JoinPoint joinPoint) {
        LOG.debug("--------------------------------------------------");
        LOG.debug("King:\t" + joinPoint.getKind());
        LOG.debug("Target:\t" + joinPoint.getTarget().toString());
        Object[] os = joinPoint.getArgs();
        LOG.debug("Args:");
        for (int i = 0; i < os.length; i++) {
            LOG.debug("\t==>参数[" + i + "]:\t" + os[i].toString());
        }
        LOG.debug("Signature:\t" + joinPoint.getSignature());
        LOG.debug("SourceLocation:\t" + joinPoint.getSourceLocation());
        LOG.debug("StaticPart:\t" + joinPoint.getStaticPart());
        LOG.debug("--------------------------------------------------");
    }
}
