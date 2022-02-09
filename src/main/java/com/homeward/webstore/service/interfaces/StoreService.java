package com.homeward.webstore.service.interfaces;

import com.homeward.webstore.VO.StoreResult;

import java.util.Map;

public interface StoreService {
    StoreResult getSpecificItems(String type, StoreResult storeResult);
}
