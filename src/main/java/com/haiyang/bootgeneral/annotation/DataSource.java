package com.haiyang.bootgeneral.annotation;

import java.lang.annotation.*;

/**
 * 多数据源注解
 * @since 1.0
 * @author jia_h
 * */

@Documented
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface DataSource {

    String value() default "master";
}
