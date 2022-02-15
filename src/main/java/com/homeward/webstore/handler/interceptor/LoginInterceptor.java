package com.homeward.webstore.handler.interceptor;

import com.homeward.webstore.mapper.PlayerInfoMapper;
import com.homeward.webstore.pojo.playerinfo.PlayerInfo;
import com.homeward.webstore.common.utils.ConstUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class LoginInterceptor implements HandlerInterceptor {
    private final PlayerInfoMapper playerInfoMapper;

    public LoginInterceptor(PlayerInfoMapper playerInfoMapper) {
        this.playerInfoMapper = playerInfoMapper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取cookie
        Cookie[] cookieArrays = request.getCookies();
        //初次验证cookie数据
        if (cookieArrays == null) {
            response.sendRedirect(request.getContextPath() + "/RedirectPage.html");
            return false;
        }

        //获取cookie中的用户名字
        String jwtToken = null;
        for (Cookie cookie : cookieArrays) {
            if ("homeward_user_info".equals(cookie.getName())) {
                jwtToken = cookie.getValue();
                break;
            }
        }

        //二次验证cookie的数据
//        if ()

        return true;
    }
}
