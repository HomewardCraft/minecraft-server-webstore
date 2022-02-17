package com.homeward.webstore.handler.interceptor;

import com.homeward.webstore.aop.annotations.JoinPointSymbol;
import com.homeward.webstore.common.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    @JoinPointSymbol
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ((request.getHeader("Authorization") == null)){
            throw new RuntimeException("token not found");
        }

        if (!JwtUtil.verity()) {
            throw new RuntimeException("user not verified");
        }
        return true;
    }
}
