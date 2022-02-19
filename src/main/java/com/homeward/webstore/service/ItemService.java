package com.homeward.webstore.service;

import com.homeward.webstore.java.bean.BO.ItemInfoBO;

import java.util.List;

public interface ItemService {
    List<ItemInfoBO> getSpecificItems(String type);
}
