package com.homeward.webstore.mapper;

import com.homeward.webstore.pojo.packages.ItemsList;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;

@Mapper
public interface StoreMapper {
    //单个参数传递不加@Param
    List<ItemsList> getStoreItems(String type);
}
