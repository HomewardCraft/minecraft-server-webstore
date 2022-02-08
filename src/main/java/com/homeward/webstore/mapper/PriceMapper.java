package com.homeward.webstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.homeward.webstore.pojo.Items;
import com.homeward.webstore.pojo.Subset.Price;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PriceMapper extends BaseMapper<Price> {
    @Select("select * from price")
    List<Price> findAll();

    @Select("select * from price where id = #{id}")
    Price findPriceById(Integer id);
}
