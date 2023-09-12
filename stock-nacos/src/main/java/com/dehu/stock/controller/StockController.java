package com.dehu.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @Classname StockController
 * @Version 1.0.0
 * @Date 2023/8/31 14:02
 * @Created by qudehu
 * @Author qudehu
 * @Description 库存
 */
@RestController
@RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("/reduct")
    public String reduce() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        System.out.println("扣减库存");
        return "扣减库存" + ",对应端口：" + port;
    }

}
