package com.homeward.webstore.mapper;

import com.homeward.webstore.java.bean.BO.ItemInfoBO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ItemMapper {
    String getItemName(Integer id);

    //单个参数传递不加@Param
    List<ItemInfoBO> getItemList(String category);

    ItemInfoBO getSpecificItem(@Param("category") String itemCategory, @Param("id") Integer itemId);
}
