package com.homeward.webstore.mapper;

import com.homeward.webstore.pojo.merchandise.ItemsList;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface StoreMapper {
    String getItemName(Integer id);

    //单个参数传递不加@Param
    List<ItemsList> getStoreItems(String type);
}
