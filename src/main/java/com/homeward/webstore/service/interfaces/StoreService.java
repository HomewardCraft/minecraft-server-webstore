package com.homeward.webstore.service.interfaces;

import com.homeward.webstore.pojo.store.Items;

import java.util.List;

public interface StoreService {
    List<Items> getSpecificItems(String type);
}
