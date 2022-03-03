package com.homeward.webstore.service;

import com.homeward.webstore.java.bean.BO.ItemInfoBO;
import com.homeward.webstore.java.bean.PO.ItemWholeInfo;
import com.homeward.webstore.mapper.ItemMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements ItemService {
    private final ItemMapper itemMapper;
    public ItemServiceImpl(ItemMapper itemMapper) {
        this.itemMapper = itemMapper;
    }

    @Override
    public List<ItemInfoBO> getItemList(String category) {
        return itemMapper.getItemList(category);
    }

    @Override
    public ItemWholeInfo getSpecificItem(Integer itemId) {
        return itemMapper.getSpecificItem(itemId);
    }
}
