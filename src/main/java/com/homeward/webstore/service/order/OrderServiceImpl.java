package com.homeward.webstore.service.order;

import com.homeward.webstore.common.enums.SystemConst;
import com.homeward.webstore.common.utils.JwtUtil;
import com.homeward.webstore.common.utils.VerificationUtil;
import com.homeward.webstore.mapper.OrderMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private final VerificationUtil verificationUtil;
    private final OrderMapper orderMapper;


    public OrderServiceImpl(VerificationUtil verificationUtil, OrderMapper orderMapper) {
        this.verificationUtil = verificationUtil;
        this.orderMapper = orderMapper;
    }

    /**
     * 返回购物车内的所有商品的价格总和
     * */
    @Override
    public Float commit() {
        String uuid = JwtUtil.getUserId();
        return orderMapper.getTotalPrice(uuid);
    }


    /**
     * 创建用户的购物车
     * */
    @Override
    @Transactional
    public void insertCart(Integer itemId, HttpServletRequest request, HttpServletResponse response) {
        String uuid = JwtUtil.getUserId();

        //使用自己的工具类判断
        verificationUtil.itemExist(itemId, uuid);
        String cookieValue = String.valueOf(itemId);
        String cookieName = uuid + cookieValue;

        //用cookie标识用户
        Cookie cookie = new Cookie(cookieName, cookieValue);
        cookie.setPath("/order");
        cookie.setMaxAge(60 * 60);

        //格式化json
        Integer itemAmount = 1;

        long rowEffected = orderMapper.insertCart(uuid, itemId, itemAmount);

        if (rowEffected == 0) {
            log.warn(uuid + " request args has wrong");
            throw new RuntimeException("args wrong");
        }

        response.addCookie(cookie);
    }


    @Override
    @Transactional
    public void updateCart(Map<String, String> map, HttpServletRequest request) {
        String uuid = JwtUtil.getUserId();

        if (map.isEmpty()) {
            log.warn(uuid + "give a null map");
            throw new RuntimeException("map is null");
        }

        //获取map中的商品id和数量
        String singleKey = null;
        String amount = null;

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if (key.contains("quantity")) {
                singleKey = key;
                amount = map.get(key);
                break;
            } else return;
        }

        //格式化
        String orderId = singleKey.replaceAll("[^0-9]", "");
        Integer itemId = Integer.valueOf(orderId);
        Integer itemAmount = Integer.valueOf(amount);

        verificationUtil.itemExist(itemId, uuid);

        orderMapper.updateCart(uuid, itemId, itemAmount);
    }


    @Override
    @Transactional
    public void deleteCart(Integer itemId, HttpServletRequest request, HttpServletResponse response) {
        String uuid = JwtUtil.getUserId();
        String cookieName = uuid + itemId;
        Cookie[] cookieArray = request.getCookies();
        for (Cookie cookie : cookieArray) {
            if (Objects.equals(cookieName, cookie.getName())) {
                cookie.setMaxAge(0);
                cookie.setPath("/order");
                response.addCookie(cookie);
                break;
            }
        }

        verificationUtil.itemExist(itemId, uuid);

        orderMapper.deleteCart(uuid, itemId);
    }
}