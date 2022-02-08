package com.homeward.webstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.homeward.webstore.pojo.Items;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface ItemsMapper extends BaseMapper<Items> {
    @Select("select * from items")
    List<Items> findAll();

}
