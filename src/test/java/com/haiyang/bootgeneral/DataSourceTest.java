package com.haiyang.bootgeneral;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Description TODO
 * @Author jia_h
 * @Date 2020/12/2 11:39
 * @Version 1.0
 */

@SpringBootTest
public class DataSourceTest {

    //@Autowired
    //@Qualifier("primaryJdbcTemplate")
    protected JdbcTemplate primaryJdbcTemplate;

    //@Autowired
    //@Qualifier("secondaryJdbcTemplate")
    protected JdbcTemplate secondaryJdbcTemplate;

    //@Test
    /*public void test_01_insert() {

        primaryJdbcTemplate.update("insert into roles (roleId, roleName, roleCode, userId, is_button) values (?, ?, ?, ?, ?)", 46, "test", "ROLE_TEST", 0, 1);

    }*/

    @Test
    public void test() {
        System.out.println("启动单元测试");
    }
}
