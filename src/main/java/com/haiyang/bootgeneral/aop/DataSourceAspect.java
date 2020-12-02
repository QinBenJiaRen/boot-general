package com.haiyang.bootgeneral.aop;

import com.haiyang.bootgeneral.annotation.DataSource;
import com.haiyang.bootgeneral.config.DynamicDataSource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Description 数据源AOP切面
 * @Author jia_h
 * @Date 2020/12/2 18:29
 * @Version 1.0
 */
@Aspect
@Component
@Slf4j
public class DataSourceAspect implements Ordered {

    private static final Log LOG = LogFactory.getLog(DataSourceAspect.class);

    /**
     * 切点：所有配置 DataSource 注解的方法
     * */
    @Pointcut("@annotation(com.haiyang.bootgeneral.annotation.DataSource)")
    public void dataSourcePointCut() {}

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSource ds = method.getAnnotation(DataSource.class);
        // 通过判断DataSource中的值来判断当前方法应用哪个数据源
        DynamicDataSource.setDataSource(ds.value());
        LOG.info("当前数据源:" + ds.value());
        try {
            return point.proceed();
        }finally {
            DynamicDataSource.clearDataSource();
            LOG.info("clean dataSource");
        }
    }

    @Override
    public int getOrder() {
        return 1;
    }
}
