package com.dehu.stock.controller;

import com.dehu.stock.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Autowired
    StockService stockService;

    @RequestMapping("/reduct")
    public String reduct(@RequestParam(value="productId") Integer productId){
        stockService.reduct(productId);
        return "扣减库存";
    }

}
