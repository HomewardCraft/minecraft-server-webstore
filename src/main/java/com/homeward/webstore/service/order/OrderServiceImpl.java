package com.homeward.webstore.service.order;

import com.homeward.webstore.common.utils.JwtUtil;
import com.homeward.webstore.mapper.OrderMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;


    public OrderServiceImpl(OrderMapper orderMapper) {
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
    public void insertCart(Integer itemId) {
        String uuid = JwtUtil.getUserId();

        Integer itemAmount = 1;

        orderMapper.insertCart(uuid, itemId, itemAmount);
    }

    /**
     * 更新用户的购物车
     * */
    @Override
    @Transactional
    public void updateCart(Map<String, String> map) {
        String uuid = JwtUtil.getUserId();

        String singleKey = "";
        String amount = "";

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if (key.contains("quantity")) {
                singleKey = key;
                amount = map.get(key);
                break;
            } else return;
        }

        String orderId = singleKey.replaceAll("[^0-9]", "");
        Integer itemId = Integer.parseInt(orderId);
        Integer itemAmount = Integer.parseInt(amount);

        orderMapper.updateCart(uuid, itemId, itemAmount);
    }


    /**
     * 删除用户的购物车
     * @param itemId item id
     */
    @Override
    @Transactional
    public void deleteCart(Integer itemId) {
        String uuid = JwtUtil.getUserId();

        orderMapper.deleteCart(uuid, itemId);
    }
}