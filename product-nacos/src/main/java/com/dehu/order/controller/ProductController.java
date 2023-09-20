package com.dehu.order.controller;

import org.apache.http.HttpResponse;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Classname OrderController
 * @Version 1.0.0
 * @Date 2023/8/31 13:59
 * @Created by qudehu
 * @Author qudehu
 * @Description 订单
 */
@RestController
@RequestMapping("/product")
public class ProductController {


    @RequestMapping("/{id}")
    public String add(@PathVariable Integer id) {
        System.out.println("查询商品：" + id);
        return "商品：" + id;

    }

}
