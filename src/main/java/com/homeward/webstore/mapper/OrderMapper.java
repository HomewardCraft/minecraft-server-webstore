package com.homeward.webstore.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.homeward.webstore.pojo.packages.Countdown;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper extends BaseMapper<Countdown> {
}
