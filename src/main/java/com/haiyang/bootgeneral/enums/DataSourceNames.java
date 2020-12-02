package com.haiyang.bootgeneral.enums;

/**
 * 数据源名称
 * @since 1.0
 * @author jia_h
 * */
public enum DataSourceNames {

    MASTER("master"),

    SLAVE("slave");

    private String name;

    DataSourceNames(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
