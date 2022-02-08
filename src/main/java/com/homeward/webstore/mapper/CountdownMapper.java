package com.homeward.webstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.homeward.webstore.pojo.Subset.Countdown;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface CountdownMapper extends BaseMapper<Countdown> {
    @Select("select * from count_down")
    List<Countdown> findAll();

    @Select("select * from count_down where id = #{id}")
    Countdown findCountdownById(Integer id);
}
