package com.homeward.webstore;

import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class TestNormal {


    @Test
    @Disabled
    void testStringFormat() {
        String orderId = String.valueOf(114514);
        String orderInfo = String.format("{%d:\"%s\"}", 1, orderId);
        System.out.println(orderInfo);
        JSONObject jsonObject = JSONObject.parseObject(orderInfo);
        String string = jsonObject.getString("1");
        System.out.println(string);
    }

    @Test
    @Disabled
    void testMapMethod() {
        Map<String, String> map = new HashMap<>();
        map.put("quantity[4240632]", "11123556714");
        map.put("quantity[4240631]", "114123");
        map.put("quantity[42411134]", "11423");
        map.put("quantity[42411236]", "112414");
        map.put("quantity[4212335]", "112314");
        map.put("quantity[424123124]", "112144");
        map.put("quantity[42403124]", "1151234");

        Set<String> strings = map.keySet();

        for (String key : strings) {
            System.out.println(key);
            System.out.println(map.get(key));
        }

        String singleKey = "quantity[4240632]";
        System.out.println(singleKey.replaceAll("[^0-9]", ""));
    }

    @Test
    @Disabled
    void testMapForEach() {
        Map<String, String> map = new HashMap<>();
        map.put("quantity[4240632]", "11123556714");
        map.put("quantity[4240631]", "114123");
        map.put("quantity[42411134]", "11423");
        map.put("quantity[42411236]", "112414");
        map.put("quantity[4212335]", "112314");
        map.put("quantity[424123124]", "112144");
        map.put("quantity[42403124]", "1151234");
        map.forEach((key, value) -> System.out.println("key: " + key + "\n" + "value: " + value));
    }

    @Test
    void testGetCause() {
        try {
            File file = new File("");
            file.getAbsolutePath();
        } catch (Exception e) {
            System.out.println(e.getCause());
        }
    }

    @Test
    void testArrayLength() {
        int[] ints = {1, 2, 3, 4};
        System.out.println(ints.length);
    }
}


