package com.homeward.webstore.aop;

import com.homeward.webstore.mapper.PlayerInfoMapper;
import com.homeward.webstore.pojo.playerinfo.PlayerInfo;
import com.homeward.webstore.util.sysconst.Const;
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

        //获取cookie中的用户信息
        String cookie_value = null;
        for (Cookie cookie : cookieArrays) {
            if ("HOMEWARD_USER_INFO".equals(cookie.getName())) {
                cookie_value = cookie.getValue();
                break;
            }
        }

        //二次验证cookie数据
        if (StringUtils.isEmpty(cookie_value)) {
            response.sendRedirect(request.getContextPath() + "/RedirectPage.html");
            return false;
        }

        //获取session
        HttpSession session = request.getSession();

        //获取session中的用户信息
        Object sessionAttribute = session.getAttribute(Const.SYSTEM_USER_SESSION);

        //判断是否过期
        if (sessionAttribute == null) {
            PlayerInfo playerInfo = playerInfoMapper.getPlayerInfo(cookie_value);

            //将信息保存到session
            session.setAttribute("HOMEWARD_USER_INFO", playerInfo);
        }

        return true;
    }
}
