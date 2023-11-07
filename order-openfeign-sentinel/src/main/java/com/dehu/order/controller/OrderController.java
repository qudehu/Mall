package com.dehu.order.controller;

import com.dehu.order.feign.StockFeignService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Classname OrderController
 * @Version 1.0.0
 * @Date 2023/8/31 13:59
 * @Created by qudehu
 * @Author qudehu
 * @Description 订单
 */
@RestController
@RequestMapping("/order")
public class OrderController {


    @Resource
    StockFeignService stockFeignService;

    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
        String msg = stockFeignService.reduce2();
        return "feign下单成功：" + msg;
    }


}
