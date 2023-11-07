package com.dehu.order.interceptor.feign;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomFeignInterceptor implements RequestInterceptor {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void apply(RequestTemplate requestTemplate) {
        //TODO you can do anything you want
        //添加请求头信息
        requestTemplate.header("xxx", "123");
        //添加查询参数
        requestTemplate.query("id2", "9");
        //修改传递的参数
        requestTemplate.uri("/9");

        logger.info("feign拦截器");
    }
}
