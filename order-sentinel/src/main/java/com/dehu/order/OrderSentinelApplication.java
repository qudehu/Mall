package com.dehu.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
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
public class OrderSentinelApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderSentinelApplication.class, args);
    }

}
