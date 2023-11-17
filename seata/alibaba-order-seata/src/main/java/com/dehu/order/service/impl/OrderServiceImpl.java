package com.dehu.order.service.impl;

import com.dehu.order.mapper.OrderMapper;
import com.dehu.order.pojo.Order;
import com.dehu.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {


    @Resource
    OrderMapper orderMapper;

    @Resource
    RestTemplate restTemplate;

    /**
     * 下单
     * @return
     */
    @Transactional
    @Override
    public Order create(Order order) {
        // 插入能否成功？
        orderMapper.insert(order);


        // 扣减库存 能否成功？
        MultiValueMap<String, Object> paramMap = new LinkedMultiValueMap<String, Object>();
        paramMap.add("productId", order.getProductId());

        String msg = restTemplate.postForObject("http://localhost:8074/stock/reduct", paramMap,String.class );

        // 异常
        int a=1/0;

        return order;
    }
}
