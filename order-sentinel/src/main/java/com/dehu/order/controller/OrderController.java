package com.dehu.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dehu.order.service.IOrderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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


    @Resource
    private IOrderService orderService;

    @RequestMapping("/add2")
    public String add2() {
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
     *
     * @return
     */
    @RequestMapping("/rule")
    public String rule() {
        System.out.println("正常访问rule");
        return "正常访问rule";
    }

    /**
     * 关联流控   访问add方法 触发get方法限流
     *
     * @return
     */
    @RequestMapping("/add")
    public String add() {
        System.out.println("下单成功!");
        return "生成订单";
    }

    /**
     * 关联流控   访问add方法 触发get方法限流
     *
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/get")
    public String get() throws InterruptedException {
        return "查询订单";
    }


    /**
     * 关联流控   访问/add 触发/get
     *
     * @return
     */
    @RequestMapping("/test1")
    public String test1() {
        return orderService.getUser();
    }

    /**
     * 关联流控  访问/add 触发/get
     *
     * @return
     * @throws InterruptedException
     */
    @RequestMapping("/test2")
    public String test2() throws InterruptedException {
        return orderService.getUser();
    }


}
