package com.homeward.webstore;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

public class TestNormal {


    @Test
    void testStringFormat() {
        String orderId = String.valueOf(114514);
        String orderInfo = String.format("{%d:\"%s\"}", 1, orderId);
        System.out.println(orderInfo);
        JSONObject jsonObject = JSONObject.parseObject(orderInfo);
        String string = jsonObject.getString("1");
        System.out.println(string);
    }


}

