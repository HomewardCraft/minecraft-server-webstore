package com.homeward.webstore.common.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 拦截器的工具类
 */
@Slf4j
public class InterceptorUtil {
    /**
     * 返回请求的uri中，商品item的id，适用于create与delete
     *
     * @param request HttpServletRequest
     * @return item id
     */
    public static Integer getItemId(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        String[] split = requestURI.split("/");
        String idString = split[split.length - 1];
        return Integer.valueOf(idString);
    }

    /**
     * 返回请求的form-data中，商品item的id，适用于update
     *
     * @param request HttpServletRequest
     * @return item id
     */
    public static Integer getItemId(HttpServletRequest request, String contains) {
        Set<String> keySet = request.getParameterMap().keySet();
        String idString = null;
        for (String key : keySet) {
            if (key.contains(contains)) {
                idString = key.replaceAll("[^0-9]", "");
                break;
            }
        }
        if (StringUtils.isBlank(idString)) {
            log.warn("invalid args");
            throw new RuntimeException("no matching key found");
        }
        return Integer.valueOf(idString);
    }

    /**
     * 判断cart的数据库是不是烂掉了
     * @param list list
     * @param <T> Class
     */
    public static <T> void isSingleColumn(List<T> list) {
        Set<T> set = new HashSet<>(list);
        if (set.size() != list.size()) {
            log.error("database has a error");
            throw new RuntimeException("database error");
        }
    }
}
