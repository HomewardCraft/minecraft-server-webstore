package com.homeward.webstore.handler.interceptor;

import com.homeward.webstore.aop.annotations.JoinPointSymbol;
import com.homeward.webstore.common.enums.StatusEnum;
import com.homeward.webstore.common.util.CommonUtils;
import com.homeward.webstore.common.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    @JoinPointSymbol
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        if ((request.getHeader("Authorization") == null)) {
            CommonUtils.throwRuntimeException(StatusEnum.JWT_NOT_FOUND);
        }
        if (!JwtUtils.verity()) {
            CommonUtils.throwRuntimeException(StatusEnum.USER_UNVERIFIED);
        }
        return true;
    }
}
