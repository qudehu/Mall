package com.dehu.order.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
    private RestTemplate restTemplate;


    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功");
        String msg = restTemplate.getForObject("http://stock-nacos/stock/reduct", String.class);
        return "下单成功：" + msg;


    }

}
