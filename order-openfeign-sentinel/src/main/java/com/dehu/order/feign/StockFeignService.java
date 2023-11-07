package com.dehu.order.feign;

import com.dehu.order.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-nacos", path = "/stock")
public interface StockFeignService {

    @RequestMapping("/reduct2")
    public String reduce2();

}
