package com.dehu.order.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-nacos", path = "/stock")
public interface StockFeignService {

    /**
     *  声明方法要和调用的rest接口对应
     */
    @RequestMapping("/reduct")
    String reduce();

}
