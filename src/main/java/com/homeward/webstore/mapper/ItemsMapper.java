package com.homeward.webstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.homeward.webstore.pojo.Items;

//要在这个类写sql 请不要继承base mapper
public interface ItemsMapper extends BaseMapper<Items> {
//    @Select("select * from items")
//    List<Items> findAll();
}
