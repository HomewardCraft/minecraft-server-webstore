package com.homeward.webstore.mapper;

import com.homeward.webstore.java.bean.BO.ItemInfoBO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    String getItemName(Integer id);

    //单个参数传递不加@Param
    List<ItemInfoBO> getStoreItemsList(String type);
}
