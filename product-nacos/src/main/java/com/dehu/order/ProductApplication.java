package com.dehu.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname OrderApplication
 * @Version 1.0.0
 * @Date 2023/8/31 11:27
 * @Created by qudehu
 * @Author qudehu
 * @Description order application
 */

@SpringBootApplication
//@EnableDiscoveryClient  //服务发现组件的注册，后期已可以省略
public class ProductApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }

}
