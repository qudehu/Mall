package com.dehu.order.feign;

import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "product-nacos", path = "/product")
public interface ProductFeignService {

    @RequestLine("GET /{id}")
    String get(@Param("id") Integer id);

}
