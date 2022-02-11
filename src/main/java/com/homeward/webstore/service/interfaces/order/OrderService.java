package com.homeward.webstore.service.interfaces.order;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public interface OrderService {
    void create(Integer id, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response);
    void update(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response);
}
