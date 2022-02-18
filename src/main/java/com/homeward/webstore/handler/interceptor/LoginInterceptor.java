package com.homeward.webstore.handler.interceptor;

import com.homeward.webstore.aop.annotations.JoinPointSymbol;
import com.homeward.webstore.common.enums.StatusEnum;
import com.homeward.webstore.common.utils.CommonUtil;
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
        if ((request.getHeader("Authorization") == null)) {
            CommonUtil.throwRuntimeException(StatusEnum.JWT_NOT_FOUND);
        }
        if (!JwtUtil.verity()) {
            CommonUtil.throwRuntimeException(StatusEnum.USER_UNVERIFIED);
        }
        return true;
    }
}
