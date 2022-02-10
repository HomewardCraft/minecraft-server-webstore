package com.homeward.webstore.aop;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

//@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取cookie
        Cookie[] cookieArrays = request.getCookies();
        //初次验证cookie数据
        if (cookieArrays == null) {
            response.sendRedirect(request.getContextPath() + "/RedirectPage.html");
            return false;
        }

        //获取cookie中的用户信息
        String cookie_name = null;
        for (Cookie cookie : cookieArrays) {
            if ("cookie_username".equals(cookie.getName())) {
                cookie_name = cookie.getValue();
                break;
            }
        }

        //二次验证cookie数据
        if (StringUtils.isEmpty(cookie_name)) {
            response.sendRedirect(request.getContextPath() + "/RedirectPage.html");
            return false;
        }


        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
