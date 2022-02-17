package com.homeward.webstore.service.cart;

import com.homeward.webstore.common.utils.CartUtil;
import com.homeward.webstore.common.utils.JwtUtil;
import com.homeward.webstore.mapper.AuthenticationMapper;
import com.homeward.webstore.mapper.CartMapper;
import com.homeward.webstore.mapper.StoreMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Slf4j
@Service
public class CartServiceImpl implements CartService {
    private final AuthenticationMapper authenticationMapper;
    private final StoreMapper storeMapper;
    private final CartMapper cartMapper;


    public CartServiceImpl(AuthenticationMapper authenticationMapper, StoreMapper storeMapper, CartMapper cartMapper) {
        this.authenticationMapper = authenticationMapper;
        this.storeMapper = storeMapper;
        this.cartMapper = cartMapper;
    }

    /**
     * 返回购物车内的所有商品的价格总和
     * */
    @Override
    public Float commit() {
        String uuid = JwtUtil.getUserId();
        return cartMapper.getTotalPrice(uuid);
    }


    /**
     * 创建用户的购物车
     * */
    @Override
    @Transactional
    public void insertCart(Integer itemId, HttpServletRequest request) {
        String uuid = JwtUtil.getUserId();

        if (storeMapper.getItemName(itemId) == null) {
            throw new RuntimeException("item not found");
        }

        List<Integer> itemIdList = authenticationMapper.itemIdList(uuid, itemId);

        CartUtil.isSingleColumn(itemIdList);

        if (itemIdList.contains(itemId)) {
            throw new RuntimeException("duplicated cart found");
        }

        Integer itemAmount = 1;

        cartMapper.insertCart(uuid, itemId, itemAmount);
    }

    /**
     * 更新用户的购物车
     * */
    @Override
    @Transactional
    public void updateCart(Map<String, String> map, HttpServletRequest request) {
        String uuid = JwtUtil.getUserId();

        Set<String> keySet =map.keySet();
        String idString = null;
        String value = null;
        for (String key : keySet) {
            if (key.contains("quantity")) {
                value = map.get(key);
                idString = key.replaceAll("[^0-9]", "");
                break;
            }
        }

        if (StringUtils.isBlank(idString)) {
            throw new RuntimeException("form data key not found");
        }

        if (Integer.parseInt(value) < 1 || Integer.parseInt(value) > 99) {
            throw new RuntimeException("item amount out of bounds");
        }

        Integer itemAmount = Integer.parseInt(value);

        Integer itemId = Integer.parseInt(idString);

        List<Integer> itemIdList = authenticationMapper.itemIdList(uuid, itemId);

        CartUtil.isSingleColumn(itemIdList);

        if (!itemIdList.contains(itemId)) {
            throw new RuntimeException("no such cart to update");
        }

        cartMapper.updateCart(uuid, itemId, itemAmount);
    }


    /**
     * 删除用户的购物车
     * @param itemId item id
     */
    @Override
    @Transactional
    public void deleteCart(Integer itemId, HttpServletRequest request) {
        String uuid = JwtUtil.getUserId();

        List<Integer> itemIdList = authenticationMapper.itemIdList(uuid, itemId);

        CartUtil.isSingleColumn(itemIdList);

        if (!itemIdList.contains(itemId)) {
            throw new RuntimeException("no such cart to delete");
        }

        cartMapper.deleteCart(uuid, itemId);
    }
}