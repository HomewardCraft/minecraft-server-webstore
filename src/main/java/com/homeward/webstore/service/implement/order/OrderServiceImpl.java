package com.homeward.webstore.service.implement.order;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.mapper.OrderMapper;
import com.homeward.webstore.pojo.packages.Countdown;
import com.homeward.webstore.service.interfaces.order.OrderService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;

    public OrderServiceImpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public void create(Integer id, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        Countdown countdown = orderMapper.selectById(id);
        if (null == countdown) {
            try {
                response.sendRedirect("/RedirectPage.html");
            } catch (Exception e) {
                //摆烂
            }
            return;
        }
        String orderId = String.valueOf(id);
        String orderInfo = String.format("{%d\"%s\"}", 1, orderId);
        Cookie cookie = new Cookie("HOMEWARD_ORDER_INFO", orderInfo);
        cookie.setMaxAge(3600);
        cookie.setPath("/checkout");
        response.addCookie(cookie);
    }

    @Override
    public void update(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookieArray = request.getCookies();
        String cookieInfo = null;
        for (Cookie cookie : cookieArray) {
            if ("HOMEWARD_ORDER_INFO".equals(cookie.getName())) {
                cookieInfo = cookie.getValue();
                JSONObject cookieObject = JSONObject.parseObject(cookieInfo);
                for (int i = 0;i < 100; i += 1) {
                    String orderId = cookieObject.getString(String.valueOf(i));
                    if (null != orderId) {
                        String orderInfo = String.format("{%d\"%s\"}", i, orderId);
                        cookie.setValue(orderInfo);
                        response.addCookie(cookie);
                    }
                }
            }
        }
    }
}
