package com.haiyang.bootgeneral.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @Description 动态数据源
 * @Author jia_h
 * @Date 2020/12/2 16:16
 * @Version 1.0
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    private static final ThreadLocal<String> contextHolder = new ThreadLocal<>();

    /**
     * 配置DataSource, defaultTargetDataSource为主数据库
     * */
    public DynamicDataSource(DataSource defaultTargetDataSource, Map<Object, Object> targetDataSource) {
        super.setDefaultTargetDataSource(defaultTargetDataSource);
        super.setTargetDataSources(targetDataSource);
        super.afterPropertiesSet();
    }

    public static void setDataSource(String dataSource) {
        contextHolder.set(dataSource);
    }

    public static String getDataSource() {
        return contextHolder.get();
    }

    public static void clearDataSource() {
        contextHolder.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return getDataSource();
    }
}
