package com.homeward.webstore.service.interfaces;

import com.homeward.webstore.VO.StoreResult;

public interface StoreService {
    StoreResult getSpecificItems(String type, StoreResult storeResult);
}
