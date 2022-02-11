package com.homeward.webstore.aop.Interceptor;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class OrderCreateInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie[] cookieArray = request.getCookies();
        if (cookieArray != null) {
            for (Cookie cookie : cookieArray) {
                if ("HOMEWARD_ORDER_INFO".equals(cookie.getName())) {
                    response.sendRedirect("/RedirectPage.html");
                    return false;
                }
            }
        }
        return true;
    }
}
