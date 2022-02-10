package com.homeward.webstore.util;

import com.alibaba.fastjson.JSONObject;

import java.util.List;

public class FixedJsonUtil {
    public static <T> List<T> fixedFormat(List<T> list, Class<T> clazz) {
        String jsonString = JSONObject.toJSONString(list);
        String formattedString = jsonString.replace("\\\"", "\"");
        return JSONObject.parseArray(formattedString, clazz);
    }
}
