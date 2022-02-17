package com.homeward.webstore.common.utils;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

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
        return Integer.parseInt(idString);
    }

    /**
     * 返回请求的form-data中，商品item的id，适用于update
     *
     * @param request HttpServletRequest
     * @return item id
     */
    public static Integer getItemId(HttpServletRequest request, String contains) {
        Map<String, String[]> parameterMap = request.getParameterMap();
        Set<String> keySet =parameterMap.keySet();
        String idString = null;
        String[] strings = null;
        for (String key : keySet) {
            if (key.contains(contains)) {
                strings = parameterMap.get(key);
                idString = key.replaceAll("[^0-9]", "");
                break;
            }
        }

        if (StringUtils.isBlank(idString)) {
            log.warn("invalid form data");
            throw new RuntimeException("form data key not found");
        }

        if (Arrays.stream(strings).count() != 1) {
            log.warn("invalid form data");
            throw new RuntimeException("form data value out of bounds");
        }

        if (Integer.parseInt(strings[0]) < 1 || Integer.parseInt(strings[0]) > 99) {
            log.warn("not valid amount");
            throw new RuntimeException("amount out of bounds");
        }

        return Integer.parseInt(idString);
    }

    /**
     * 判断cart的数据库是不是烂掉了
     * @param list list
     * @param <T> Class
     */
    public static <T> void isSingleColumn(List<T> list) {
        Set<T> set = new HashSet<>(list);
        if (set.size() != list.size()) {
            log.error("database has an error");
            throw new RuntimeException("database error");
        }
    }
}
