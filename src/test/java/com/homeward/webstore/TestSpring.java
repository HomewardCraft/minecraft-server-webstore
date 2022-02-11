package com.homeward.webstore;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.mapper.StoreMapper;
import com.homeward.webstore.util.RedisUtil;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.Serializable;
import java.util.Date;

@Slf4j
@SpringBootTest
public class TestSpring {

    @Autowired
    private StoreMapper storeMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Autowired
    private RestTemplate restTemplate;

    @Test
    @Disabled
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

    }

    @Test
    @Disabled
    void testRedisUtil() {
        boolean set = redisUtil.set("Ba1oretto", "{\"114514\":1}");
        System.out.println("set: " + set);

        Object get = redisUtil.get("Ba1oretto");
        System.out.println(get);

        boolean update = redisUtil.update("Ba1oretto", "{\"114514\":1919810}");
        System.out.println("update: " + update);

        boolean expire = redisUtil.setExpire("Ba1oretto", 10);
        System.out.println("expire: " + expire);

        long time1 = redisUtil.getExpire("Ba1oretto");
        System.out.println("time1: " + time1);

        boolean persist = redisUtil.persist("Ba1oretto");
        System.out.println("persist: " + persist);

        long time2 = redisUtil.getExpire("Ba1oretto");
        System.out.println("time2: " + time2);

        boolean delete = redisUtil.del("Ba1oretto");
        System.out.println("delete: " + delete);

        boolean hasKey = redisUtil.hasKey("Ba1oretto");
        System.out.println("hasKey: " + hasKey);
    }

    @Test
    void testRedis() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setName("jack");
        userInfo.setCreateTime(new Date());
        // 放入redis
        redisUtil.set("user", userInfo, 5);
        // 从redis中获取
        System.out.println("获取到数据：" + redisUtil.get("user") +
        "过期时间: " + redisUtil.getExpire("user"));
    }

    @Test
    void testRedisValue() {
        System.out.println(redisUtil.get("Ba1oretto"));
    }
}

@Data
@Accessors(chain = true)
class UserInfo implements Serializable {
    /**
     * id
     */
    private Integer id;
    /**
     * 姓名
     */
    private String name;
    /**
     * 创建时间
     */
    private Date createTime;
}
