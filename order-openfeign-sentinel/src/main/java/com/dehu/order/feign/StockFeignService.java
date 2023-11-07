package com.dehu.order.feign;

import com.dehu.order.config.FeignConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

// 需要指定fallback为指定的实现类
@FeignClient(name = "stock-nacos", path = "/stock",fallback = StockFeignServiceFallback.class)
public interface StockFeignService {

    @RequestMapping("/reduct2")
    public String reduce2();

}
