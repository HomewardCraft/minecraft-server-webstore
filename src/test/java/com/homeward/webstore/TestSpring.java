package com.homeward.webstore;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.mapper.StoreMapper;
import com.homeward.webstore.pojo.playerinfo.Properties;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class TestSpring {

    @Autowired
    private StoreMapper storeMapper;

    @Value("${interceptor.addPath:/**}")
    private List<String> addPath;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    void testGetParam() {
        String URL = String.format("https://api.mojang.com/users/profiles/minecraft/%s", "Ba1oretto");
        String OriginMessage = restTemplate.getForObject(URL, String.class);
        JSONObject ObjectedMessage = JSONObject.parseObject(OriginMessage);

        String UUID = ObjectedMessage.getString("id");
        String fullURL = String.format("https://sessionserver.mojang.com/session/minecraft/profile/%s?unsigned=false", UUID);
        String LastMessage = restTemplate.getForObject(fullURL, String.class);

        JSONObject playerProfile = JSONObject.parseObject(LastMessage);

        JSONArray propertyArray = playerProfile.getJSONArray("properties");
        String propertyString = propertyArray.toJSONString();
        String formattedProperty = propertyString.replaceAll("[\\[\\]]", "");
        JSONObject propertyObject = JSONObject.parseObject(formattedProperty);

        String id = playerProfile.getString("id");
        String name = playerProfile.getString("name");
        String propertyName = propertyObject.getString("name");
        String value = propertyObject.getString("value");
        String signature = propertyObject.getString("signature");
        String legacy = playerProfile.getString("legacy");

        System.out.println(id);
        System.out.println(name);
        System.out.println(propertyName);
        System.out.println(value);
        System.out.println(signature);
        System.out.println(legacy);
    }

    @Test
    void testPropertyValue() {
        for (String s : addPath) {
            System.out.println(s);
        }
    }
}

