package com.dehu.stock.mapper;


import com.dehu.stock.pojo.Stock;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StockMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Stock record);

    Stock selectByPrimaryKey(Integer id);

    List<Stock> selectAll();

    int updateByPrimaryKey(Stock record);

    void reduct(Integer productId);
}