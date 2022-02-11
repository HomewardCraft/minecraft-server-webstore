package com.homeward.webstore.service.interfaces.store;

import com.homeward.webstore.pojo.packages.ItemsList;

import java.util.List;

public interface StoreService {
    List<ItemsList> getSpecificItems(String type);
}
