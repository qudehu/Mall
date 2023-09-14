package com.dehu.order;

import com.dehu.ribbon.RibbonRandomRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;
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
@RibbonClients(value = {
        //该注解内可以配置多个，对服务进行配置，可以针对不同的服务使用不同的负载均衡策略,
        @RibbonClient(name = "stock-nacos", configuration = RibbonRandomRuleConfig.class)
})
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
