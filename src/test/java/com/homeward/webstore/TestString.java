package com.homeward.webstore;

import com.homeward.webstore.util.JsonMap;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

public class TestString {
    @Test
    void testString() {
        Map<String, String> jsonMap = new JsonMap().getJsonMap("{\"name\":\"Ba1oretto\",\"id\":\"619377de9ada41388ef93dbf9fe56320\"}");
        System.out.println(jsonMap);
    }
}