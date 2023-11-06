package com.dehu.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

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

    @RequestMapping("/flow")
    @SentinelResource(value = "flow", blockHandler = "flowBlockHandler")     // 针对某一资源，不使用统一的流控处理
    public String flow() {
        System.out.println("访问：" + new Date());
        return "正常访问";
    }

    public String flowBlockHandler(BlockException e) {
        return "单独流控flow";
    }


}
