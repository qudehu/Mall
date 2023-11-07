package com.dehu.order.service.impl;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.dehu.order.service.IOrderService;
import org.springframework.stereotype.Service;

@Service
public class OrderSericeImpl implements IOrderService {
    @Override
    // 添加value，就可以针对业务方法进行流控
    // 我们使用了SentinelResource，就不会使用统一的异常处理，所以需要指定对应的异常处理方法
    @SentinelResource(value = "getUser", blockHandler = "blockHandlerGetUser")
    public String getUser() {
        return "查询用户";
    }

    /**
     * BlockException参数一定要有，否则将不生效
     *
     * @param e
     * @return
     */
    public String blockHandlerGetUser(BlockException e) {
        return "被流控了";
    }
}
