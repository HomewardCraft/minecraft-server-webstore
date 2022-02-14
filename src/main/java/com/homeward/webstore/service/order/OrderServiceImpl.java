package com.homeward.webstore.service.order;

import com.homeward.webstore.common.utils.RedisUtil;
import com.homeward.webstore.common.utils.VerificationUtil;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private final RedisUtil redisUtil;
    private final VerificationUtil verificationUtil;


    public OrderServiceImpl(RedisUtil redisUtil, VerificationUtil verificationUtil) {
        this.redisUtil = redisUtil;
        this.verificationUtil = verificationUtil;
    }


    @Override
    public void create(Integer id, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        //使用自己的工具类判断
        Boolean orderExist = verificationUtil.orderExist(id, "/RedirectPage.html", response);
        if (!orderExist) {
            return;
        }

        //从user info!!! 中获取用户名
        Cookie[] cookieArray = request.getCookies();
        String userName = null;
        for (Cookie cookie : cookieArray) {
            if ("HOMEWARD_USER_INFO".equals(cookie.getName())) {
                userName = cookie.getValue();
            }
        }

        //用cookie标识用户
        Cookie cookie = new Cookie("HOMEWARD_ORDER_INFO", userName);
        cookie.setPath("/checkout");
        cookie.setMaxAge(2 * 60 * 60);

        //格式化json
        String orderId = String.valueOf(id);
        Integer orderAmount = 1;
        String orderInfo = String.format("{\"%s\":%d}", orderId, orderAmount);

        //存储到redis
        redisUtil.set(userName, orderInfo, 2 * 60 * 60);

        response.addCookie(cookie);
    }


    @Override
    public void update(Map<String, String> map, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        if (map.isEmpty()) {
            return;
        }

        //获取map中的商品id和数量
        String singleKey = null;
        String singleValue = null;

        Set<String> keySet = map.keySet();
        for (String key : keySet) {
            if (key.contains("quantity")) {
                singleKey = key;
                singleValue = map.get(key);
                break;
            } else return;
        }

        //格式化
        String orderId = singleKey.replaceAll("[^0-9]", "");
        Integer orderAmount = Integer.valueOf(singleValue);
        Integer idInteger = Integer.valueOf(orderId);


        Boolean orderExist = verificationUtil.orderExist(idInteger, "/RedirectPage.html", response);
        if (!orderExist) {
            return;
        }

        String orderInfo = String.format("{\"%s\":%d}", orderId, orderAmount);

        //从order info!!! 中取用户名
        Cookie[] cookieArray = request.getCookies();
        String userName = null;
        for (Cookie cookie : cookieArray) {
            if ("HOMEWARD_ORDER_INFO".equals(cookie.getName())) {
                userName = cookie.getValue();
            }
        }

        redisUtil.update(userName, orderInfo);
    }


    @Override
    public void remove(Integer id, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        Boolean orderExist = verificationUtil.orderExist(id, "/RedirectPage.html", response);
        if (!orderExist) {
            return;
        }

        Cookie[] cookieArray = request.getCookies();
        String userName;
        for (Cookie cookie : cookieArray) {
            if ("HOMEWARD_ORDER_INFO".equals(cookie.getName())) {
                userName = cookie.getValue();
                redisUtil.del(userName);
                cookie.setMaxAge(0);
                cookie.setPath("/checkout");
                response.addCookie(cookie);
            }
            break;
        }
    }
}