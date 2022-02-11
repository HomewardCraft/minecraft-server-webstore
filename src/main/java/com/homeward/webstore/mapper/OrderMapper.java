package com.homeward.webstore.mapper;

import com.homeward.webstore.pojo.packages.ItemsList;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface OrderMapper{
    ItemsList getItemId(Integer id);
}
