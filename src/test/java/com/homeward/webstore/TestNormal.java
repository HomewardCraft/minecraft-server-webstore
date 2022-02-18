package com.homeward.webstore;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.java.bean.VO.R;
import com.homeward.webstore.common.enums.StatusEnum;
import com.homeward.webstore.common.consts.SystemConst;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

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

    @Test
    void testEnumsStatus() {
        Integer successStatusCode = StatusEnum.SUCCESS.getCode();
        String successStatusMessage = StatusEnum.SUCCESS.getMessage();
        System.out.println(successStatusCode + successStatusMessage);
    }

    @Test
    void testResultSet() {
        R ok = R.ok();
        System.out.println(ok);

    }

    @Test
    void testEnums() {
        System.out.println(SystemConst.SYSTEM_PROJECT_NAME.getName());
    }

    @Test
    void testDuplicatedArray() {
        ArrayList<Integer> integers = new ArrayList<>();
//        integers.add(1);
//        integers.add(2);
//        integers.add(3);
//        integers.add(4);
//        integers.add(5);
        Set<Integer> set = new HashSet<>(integers);
        if(set.size() != integers.size()){
            System.out.println(0);
        }else{
            System.out.println(1);
        }
    }

    @Test
    void testArrays() {
        String[] strings = {"10"};
        System.out.println(Arrays.stream(strings).count());
        Integer integer = Integer.valueOf(strings[0]);
        System.out.println(integer);
    }

    @Test
    void testException() {
        String s = null;
        s.hashCode();
    }

    @Test
    void testDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日HH点mm分ss.SSS秒");
        Calendar calendar = Calendar.getInstance();
        String format = dateFormat.format(calendar.getTime());
        System.out.println(format);
    }
}


