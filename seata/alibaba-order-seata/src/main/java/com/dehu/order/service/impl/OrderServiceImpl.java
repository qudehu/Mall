package com.dehu.order.service.impl;

import com.dehu.order.api.StockService;
import com.dehu.order.mapper.OrderMapper;
import com.dehu.order.pojo.Order;
import com.dehu.order.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
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
     *
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
        int a = 1 / 0;

        return order;
    }

    @Override
    @Trace
    // key为getAll，value为返回的对象
    // key一般为方法名，value一般为固定的，如果是返回值，那么就是：returnedObj
    // 如果返回的是arg[n],则返回的是参数
    @Tag(key = "getAll", value = "returnedObj")
    public List<Order> all() throws InterruptedException {
        TimeUnit.SECONDS.sleep(2);
        return orderMapper.selectAll();
    }

    @Override
    @Trace
    // key为getAll，第一个value为返回的对象，第二个当其为arg[0]时，会记录第一个参数
    @Tags({@Tag(key = "get", value = "returnedObj"),
            @Tag(key = "get", value = "arg[0]")})
    public Order get(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

}
