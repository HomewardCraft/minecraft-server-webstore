package com.homeward.webstore.service.store;

import com.homeward.webstore.java.bean.BO.ItemInfoBO;

import java.util.List;

public interface StoreService {
    List<ItemInfoBO> getSpecificItems(String type);
}
