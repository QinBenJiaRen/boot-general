package com.haiyang.bootgeneral.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

/**
 * @Description 数据源配置管理
 * @Author jia_h
 * @Date 2020/12/2 10:38
 * @Version 1.0
 */
public class DruidConfig {

    @Bean
    public FilterRegistrationBean filterRegistrationBean() {
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        //filterRegistrationBean.setFilter(new WebStatFilter());
        // 所有请求进行监控管理
        filterRegistrationBean.addUrlPatterns("/*");
        filterRegistrationBean.addInitParameter("exclusions", "*.js, *.gif, *.jpg, *.css, /druid/*");
        return filterRegistrationBean;
    }
}
