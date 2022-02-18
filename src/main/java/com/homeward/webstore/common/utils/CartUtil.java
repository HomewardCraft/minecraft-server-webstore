package com.homeward.webstore.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * cart service的工具类
 */
@Slf4j
public class CartUtil {

    /**
     * 判断cart的表是不是烂掉了
     * @param list
     * @param <T>
     */
    public static <T> void isSingleColumn(List<T> list) {
        Set<T> set = new HashSet<>(list);
        // 数据库寄啦
        if (set.size() != list.size()) {
            throw new RuntimeException("database error");
        }
    }
}
