package com.homeward.webstore.service.cart;

import jakarta.servlet.http.HttpServletRequest;

import java.util.Map;

public interface CartService {
    void insertCart(Integer itemName, HttpServletRequest request);
    void updateCart(Map<String, String> itemMap, HttpServletRequest request);
    void deleteCart(Integer itemName, HttpServletRequest request);
    Float commit();
}
