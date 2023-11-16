package com.dehu.stock.service.impl;

import com.dehu.stock.mapper.StockMapper;
import com.dehu.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockMapper stockMapper;

    @Override
    public void reduct(Integer productId) {
        System.out.println("更新商品:"+productId);
        stockMapper.reduct(productId);
    }
}
