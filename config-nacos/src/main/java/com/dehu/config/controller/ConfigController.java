package com.dehu.config.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/config")
// @RefreshScope注解可以保证在controller业务中也能实时获取配置文件中的数据变化
@RefreshScope
public class ConfigController {

    @Value("${user.name}")
    public String name;

    @RequestMapping("/show")
    public String show() {
        return name;
    }

}
