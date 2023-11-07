package com.dehu.order.feign;

import org.springframework.stereotype.Component;

//实现接口，并注册为bean
@Component
public class StockFeignServiceFallback implements StockFeignService{
    @Override
    public String reduce2() {
        return "被降级了";
    }
}
