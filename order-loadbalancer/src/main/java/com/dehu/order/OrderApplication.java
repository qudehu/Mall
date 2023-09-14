package com.dehu.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
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
public class OrderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    /**
     * RestTemplate，不需要写配置类了
     */
    @Bean
    @LoadBalanced //添加loadBalance注解，可以使用nacos的模式进行调用
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
