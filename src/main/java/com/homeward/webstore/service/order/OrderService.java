package com.homeward.webstore.service.order;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public interface OrderService {
    void insertCart(Integer itemName);
    void updateCart(Map<String, String> itemMap);
    void deleteCart(Integer itemName);
    Float commit();
}
