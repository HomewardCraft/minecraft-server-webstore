package com.homeward.webstore.mapper;

import com.homeward.webstore.java.bean.PO.ItemWholeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminItemManipulationMapper {
    Boolean insertDescription(ItemWholeInfo information);
    Boolean insertItemInformation(ItemWholeInfo information);
    Boolean insertItemInformationList(@Param("ItemInformation") List<ItemWholeInfo> information);
    Long isExist(String name);
}
