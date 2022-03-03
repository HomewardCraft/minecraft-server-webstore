package com.homeward.webstore.mapper;

import com.homeward.webstore.java.bean.BO.ItemInfoBO;
import com.homeward.webstore.java.bean.PO.ItemWholeInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ItemMapper {
    String getItemName(Integer id);

    //单个参数传递不加@Param
    List<ItemInfoBO> getItemList(String category);

    ItemWholeInfo getSpecificItem(Integer itemId);
}
