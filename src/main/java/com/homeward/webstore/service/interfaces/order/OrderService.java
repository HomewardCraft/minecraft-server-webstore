package com.homeward.webstore.service.interfaces.order;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.util.Map;

public interface OrderService {
    void create(Integer id, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response);
    void update(Map<String, String>map, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response);
    void remove(Integer id, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response);
}
