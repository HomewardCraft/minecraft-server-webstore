package com.homeward.webstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.homeward.webstore.pojo.Subset.Countdown;


//要在这个类写sql 请不要继承base mapper
public interface CountdownMapper extends BaseMapper<Countdown> {
//    @Select("select * from count_down")
//    List<Countdown> findAll();
//
//    @Select("select * from count_down where id = #{id}")
//    Countdown findCountdownById(Integer id);
}
