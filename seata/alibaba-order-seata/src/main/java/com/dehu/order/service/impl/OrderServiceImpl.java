package com.dehu.order.service.impl;

import com.dehu.order.api.StockService;
import com.dehu.order.mapper.OrderMapper;
import com.dehu.order.pojo.Order;
import com.dehu.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.TimeUnit;

/***
 * @Author 徐庶   QQ:1092002729
 * @Slogan 致敬大师，致敬未来的你
 */
@Service
public class OrderServiceImpl implements OrderService {


    @Autowired
    OrderMapper orderMapper;

    @Autowired
    StockService stockService;

    /**
     * 下单
     * @return
     */
    @GlobalTransactional
    @Override
    public Order create(Order order) {
        // 插入能否成功？
        orderMapper.insert(order);

        // 扣减库存 能否成功？
        stockService.reduct(order.getProductId());

        // 异常
        int a=1/0;

        return order;
    }

}
