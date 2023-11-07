package com.dehu.order.feign;

import org.springframework.stereotype.Component;

@Component
public class StockFeignServiceFallback implements StockFeignService{
    @Override
    public String reduce2() {
        return "被降级了";
    }
}
