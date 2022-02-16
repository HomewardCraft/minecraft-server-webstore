package com.homeward.webstore.service.order;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.util.Map;

public interface OrderService {
    void insertCart(Integer itemName, HttpServletRequest request, HttpServletResponse response);
    void updateCart(Map<String, String> itemMap, HttpServletRequest request);
    void deleteCart(Integer itemName, HttpServletRequest request, HttpServletResponse response);
    Float commit();
}
