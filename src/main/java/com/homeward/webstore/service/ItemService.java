package com.homeward.webstore.service;

import com.homeward.webstore.java.bean.PO.ItemDetail;
import com.homeward.webstore.java.bean.PO.ItemShowCaseInfo;

import java.util.List;

public interface ItemService {
    List<ItemShowCaseInfo> getItemList(String type);

    ItemDetail getSpecificItem(Integer itemId);

    String getRuleDetails(Integer ruleId);
}
