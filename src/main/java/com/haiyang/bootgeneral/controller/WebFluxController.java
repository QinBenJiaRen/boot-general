package com.haiyang.bootgeneral.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description TODO
 * @Author jia_h
 * @Date 2020/12/4 13:58
 * @Version 1.0
 */

@RestController
public class WebFluxController {

    @RequestMapping("/")
    public String index() {
        return "Hello Docker";
    }
}
