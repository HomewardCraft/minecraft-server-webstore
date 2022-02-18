package com.homeward.webstore.service.store;

import com.homeward.webstore.java.bean.BO.ItemInfoBO;
import com.homeward.webstore.mapper.StoreMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreMapper storeMapper;
    public StoreServiceImpl(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    @Override
    public List<ItemInfoBO> getSpecificItems(String type) {
        return storeMapper.getStoreItemsList(type);
    }
}
