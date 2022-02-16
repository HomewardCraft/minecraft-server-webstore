package com.homeward.webstore.handler.interceptor;

import com.homeward.webstore.common.utils.JwtUtil;
import com.homeward.webstore.mapper.AuthenticationMapper;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.List;
import java.util.Objects;
import java.util.Set;

@Slf4j
@Component
public class OrderUpdateInterceptor implements HandlerInterceptor {
    private final AuthenticationMapper authenticationMapper;

    public OrderUpdateInterceptor(AuthenticationMapper authenticationMapper) {
        this.authenticationMapper = authenticationMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uuid = JwtUtil.getUserId();

        Cookie[] cookieArray = request.getCookies();

        if (cookieArray == null) {
            log.error(uuid + " need a cart to update");
            throw new RuntimeException("no such cart found");
        }

        List<Integer> itemIdList = authenticationMapper.isSingleCart(uuid);

        Set<String> keySet = request.getParameterMap().keySet();
        Integer itemId = null;
        for (String key : keySet) {
            if (key.contains("quantity")) {
                String idString = key.replaceAll("[^0-9]", "");
                itemId = Integer.valueOf(idString);
                break;
            }
        }

        String cookieName = uuid + itemId;

        for (Cookie cookie : cookieArray) {
            if (Objects.equals(cookieName, cookie.getName()) && itemIdList.contains(itemId)) {
                return true;
            }
        }

        log.error(uuid + " need a cart to update");
        throw new RuntimeException("no such cart found");
    }
}