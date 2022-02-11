package com.homeward.webstore.service.implement.order;

import com.homeward.webstore.mapper.OrderMapper;
import com.homeward.webstore.pojo.packages.ItemsList;
import com.homeward.webstore.service.interfaces.order.OrderService;
import com.homeward.webstore.util.RedisUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Service
public class OrderServiceImpl implements OrderService {
    private final RedisUtil redisUtil;
    private final OrderMapper orderMapper;


    public OrderServiceImpl(RedisUtil redisUtil, OrderMapper orderMapper) {
        this.redisUtil = redisUtil;
        this.orderMapper = orderMapper;
    }


    @Override
    public void create(Integer id, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        ItemsList itemId = orderMapper.getItemId(id);
        if (itemId == null) {
            return;
        }

        //从user info!!! 中获取用户名
        Cookie[] cookieArray = request.getCookies();
        String userName = null;
        for (Cookie cookie : cookieArray) {
            if ("HOMEWARD_USER_INFO".equals(cookie.getName())) {
                userName = cookie.getValue();
            }
        }

        //用cookie标识用户
        Cookie cookie = new Cookie("HOMEWARD_ORDER_INFO", userName);
        cookie.setPath("/checkout");
        cookie.setMaxAge(2 * 60 * 60);

        //格式化json
        String orderId = String.valueOf(id);
        Integer orderAmount = 1;
        String orderInfo = String.format("{\"%s\":%d}", orderId, orderAmount);

        //存储到redis
        redisUtil.set(userName, orderInfo, 2 * 60 * 60);

        response.addCookie(cookie);
    }


    @Override
    public void update(Map<String, String> map, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        if (map.isEmpty()) {
            return;
        }

        //获取map中的商品id和数量
        String singleKey = null;
        String singleValue = null;

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if (key.contains("quantity")) {
                singleKey = key;
                singleValue = map.get(key);
                break;
            } else return;
        }

        //格式化
        String orderId = singleKey.replaceAll("[^0-9]", "");
        Integer orderAmount = Integer.valueOf(singleValue);
        Integer idInteger = Integer.valueOf(orderId);

        ItemsList itemId = orderMapper.getItemId(idInteger);
        if (itemId == null) {
            return;
        }

        String orderInfo = String.format("{\"%s\":%d}", orderId, orderAmount);

        //从order info!!! 中取用户名
        Cookie[] cookieArray = request.getCookies();
        String userName = null;
        for (Cookie cookie : cookieArray) {
            if ("HOMEWARD_ORDER_INFO".equals(cookie.getName())) {
                userName = cookie.getValue();
            }
        }

        redisUtil.update(userName, orderInfo);
    }


    @Override
    public void remove(Integer id, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        ItemsList itemId = orderMapper.getItemId(id);
        if (itemId == null) {
            return;
        }

        Cookie[] cookieArray = request.getCookies();
        String userName;
        for (Cookie cookie : cookieArray) {
            if ("HOMEWARD_ORDER_INFO".equals(cookie.getName())) {
                userName = cookie.getValue();
                redisUtil.del(userName);
                cookie.setMaxAge(0);
                cookie.setPath("/checkout");
                response.addCookie(cookie);
            }
            break;
        }
    }
}