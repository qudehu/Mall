package com.dehu.order.feign;

import com.dehu.order.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/*
* 添加feign接口和方法
* name 指定调用rest接口所对应的服务名
* path 指定调用rest接口所在的StockController指定的@RequestMapping
* configuration指定所需要使用的配置文件
* */
@FeignClient(name = "stock-nacos", path = "/stock", configuration = FeignConfig.class)
public interface StockFeignService {

    /**
     *  声明方法要和调用的rest接口对应
     */
    @RequestMapping("/reduct")
    String reduce();

}
