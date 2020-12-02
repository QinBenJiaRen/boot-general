package com.haiyang.bootgeneral.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.haiyang.bootgeneral.enums.DataSourceNames;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 配置动态数据源
 * @Author jia_h
 * @Date 2020/12/2 16:21
 * @Version 1.0
 */
@Configuration
public class DynamicDataSourceConfig {

    /**
     * 创建DataSource Bean
     * */
    @Bean("master")
    @ConfigurationProperties("spring.datasource.druid.master")
    public DataSource masterDataSource() {
        return new DruidDataSource();
    }

    @Bean("slave")
    @ConfigurationProperties("spring.datasource.druid.slave")
    public DataSource slaveDataSource() {
        return new DruidDataSource();
    }

    /**
     * 设置动态数据源，通过@Primary 来确定主数据源
     *
     * */
    @Bean
    @Primary
    public DataSource createDynamicDataSource(@Qualifier("master") DataSource master, @Qualifier("slave") DataSource slave) {
        Map<Object, Object> targetDataSource = new HashMap<>(16);
        targetDataSource.put(DataSourceNames.MASTER.getName(), master);
        targetDataSource.put(DataSourceNames.SLAVE.getName(), slave);
        return new DynamicDataSource(masterDataSource(), targetDataSource);

    }




}
