package com.haiyang.bootgeneral.template;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;


/**
 * @Description JDBC操作模板,对JdbcTemplate的简单封装,使用appliaction-dev.yml配置文件时使用
 * @Author jia_h
 * @Date 2020/12/2 10:33
 * @Version 1.0
 */
//@Component
public class MicroJdbcTemplate {

    @Bean(name = "primaryJdbcTemplate")
    public JdbcTemplate primaryJdbcTemplate(@Qualifier("primaryDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "secondaryJdbcTemplate")
    public JdbcTemplate secondaryJdbcTemplate(@Qualifier("secondaryDataSource") DataSource dataSource) {
        return new JdbcTemplate((dataSource));
    }
}
