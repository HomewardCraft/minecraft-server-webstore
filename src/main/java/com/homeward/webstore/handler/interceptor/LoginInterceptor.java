package com.homeward.webstore.handler.interceptor;

import com.homeward.webstore.common.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.Enumeration;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ((request.getHeader("Authorization") == null)){
            throw new RuntimeException("Unverified");
        }

        if (!JwtUtil.verity()) {
            throw new RuntimeException("Unverified");
        }
        return true;
    }
}
