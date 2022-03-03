package com.homeward.webstore.service;

import com.homeward.webstore.java.bean.BO.ItemInfoBO;
import com.homeward.webstore.java.bean.PO.ItemWholeInfo;

import java.util.List;

public interface ItemService {
    List<ItemInfoBO> getItemList(String type);

    ItemWholeInfo getSpecificItem(Integer itemId);
}
