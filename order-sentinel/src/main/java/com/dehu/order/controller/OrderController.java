package com.dehu.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

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

    @RequestMapping("/add")
    public String add() {
        System.out.println("访问add：" + new Date());
        return "正常访问add";
    }

    @RequestMapping("/flow")
    @SentinelResource(value = "flow", blockHandler = "flowBlockHandler")     // 针对某一资源，不使用统一的流控处理
    public String flow() {
        System.out.println("访问：" + new Date());
        return "正常访问";
    }

    /**
     * 测试时，最好使用干净的浏览器，否则相应时间较长
     *
     * @param e
     * @return
     */
    public String flowBlockHandler(BlockException e) {
        return "单独流控flow";
    }

    /**
     * 并发线程-对应方法
     *
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/flowThread")
    @SentinelResource(value = "flowThread", blockHandler = "flowBlockHandler")
    public String flowThread() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        System.out.println("正常访问");
        return "正常访问";
    }

    /**
     * 统一异常处理-请求方法
     * @return
     */
    @RequestMapping("/rule")
    public String rule() {
        System.out.println("正常访问rule");
        return "正常访问rule";
    }


}
