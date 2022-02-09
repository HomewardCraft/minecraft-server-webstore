package com.homeward.webstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.homeward.webstore.pojo.Subset.Price;

//要在这个类写sql 请不要继承base mapper
public interface PriceMapper extends BaseMapper<Price> {
//    @Select("select * from price")
//    List<Price> findAll();
//
//    @Select("select * from price where id = #{id}")
//    Price findPriceById(Integer id);
}
