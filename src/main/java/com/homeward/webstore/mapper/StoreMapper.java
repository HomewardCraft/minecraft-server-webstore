package com.homeward.webstore.mapper;

import com.homeward.webstore.pojo.store.Items;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StoreMapper {
    //单个参数传递不加@Param
    List<Items> getStoreItems(String type);
}
