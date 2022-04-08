package com.homeward.webstore.mapper;

import com.homeward.webstore.java.bean.BO.ItemName;
import com.homeward.webstore.java.bean.PO.ItemWholeInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface AdminItemManipulationMapper {
    Boolean insertDescription(ItemWholeInfo information);
    Boolean insertItemInformation(ItemWholeInfo information);
    Boolean insertItemInformationList(@Param("ItemInformation") List<ItemWholeInfo> information);

    Boolean updateDescription(ItemWholeInfo information);
    Boolean updateExtrasInformation(ItemWholeInfo information);
    Boolean updateCratesInformation(ItemWholeInfo information);
    Boolean updateCratesInformationName(@Param("cratesInformationNameList") List<ItemName> name, String descriptionId);

    Long isExist(@Param("category") String category, @Param("name") String name);
    String selectDescriptionId(Integer itemId);
    List<ItemName> selectCratesId(String descriptionId);
}
