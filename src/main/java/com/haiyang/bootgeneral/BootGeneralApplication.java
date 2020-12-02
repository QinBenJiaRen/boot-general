package com.haiyang.bootgeneral;

import com.haiyang.bootgeneral.config.DynamicDataSourceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Import;

/**
 * 动态数据源配置，需要将自有的配置依赖（DynamicDataSourceConfig）,将原有的依赖去除（DataSourceAutoConfiguration）
 * */
@Import({DynamicDataSourceConfig.class})
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class BootGeneralApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootGeneralApplication.class, args);
	}

}
