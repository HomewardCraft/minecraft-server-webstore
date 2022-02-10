package com.homeward.webstore.service.implement;

import com.homeward.webstore.mapper.StoreMapper;
import com.homeward.webstore.pojo.store.Items;
import com.homeward.webstore.service.interfaces.StoreService;
import com.homeward.webstore.util.FixedJsonUtil;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    private final StoreMapper storeMapper;
    public StoreServiceImpl(StoreMapper storeMapper) {
        this.storeMapper = storeMapper;
    }

    @Override
    public List<Items> getSpecificItems(String type) {
        List<Items> itemsList= storeMapper.getStoreItems(type);
        return FixedJsonUtil.fixedFormat(itemsList, Items.class);
    }
}
