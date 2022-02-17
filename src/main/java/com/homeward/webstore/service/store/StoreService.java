package com.homeward.webstore.service.store;

import com.homeward.webstore.pojo.merchandise.ItemsList;

import java.util.List;

public interface StoreService {
    List<ItemsList> getSpecificItems(String type);
}
