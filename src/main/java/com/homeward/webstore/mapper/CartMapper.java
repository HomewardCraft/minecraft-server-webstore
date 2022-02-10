package com.homeward.webstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.homeward.webstore.pojo.store.Cart;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CartMapper extends BaseMapper<Cart> {

    @Select("select * from cart where uuid = #{UUID}")
    List<Cart> findCartByuuid(String UUID);

}
