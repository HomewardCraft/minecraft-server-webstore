package com.homeward.webstore.handler.interceptor;

import com.homeward.webstore.common.utils.InterceptorUtil;
import com.homeward.webstore.common.utils.JwtUtil;
import com.homeward.webstore.mapper.AuthenticationMapper;
import com.homeward.webstore.mapper.StoreMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;

@Slf4j
@Component
public class OrderCreateInterceptor implements HandlerInterceptor {
    private final AuthenticationMapper authenticationMapper;
    private final StoreMapper storeMapper;

    public OrderCreateInterceptor(AuthenticationMapper authenticationMapper, StoreMapper storeMapper) {
        this.authenticationMapper = authenticationMapper;
        this.storeMapper = storeMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uuid = JwtUtil.getUserId();

        Integer itemId = InterceptorUtil.getItemId(request);

        if (storeMapper.getItemName(itemId) == null) {
            log.warn(uuid + " query a void item");
            throw new RuntimeException("item not found");
        }

        List<Integer> itemIdList = authenticationMapper.itemIdList(uuid, itemId);

        InterceptorUtil.isSingleColumn(itemIdList);

        if (itemIdList.contains(itemId)) {
            log.warn(uuid + " have duplicated cart");
            throw new RuntimeException("duplicated cart found");
        }

        return true;
    }
}
