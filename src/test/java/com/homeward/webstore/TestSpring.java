package com.homeward.webstore;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.common.util.JwtUtils;
import com.homeward.webstore.java.bean.PO.ItemShowCaseInfo;
import com.homeward.webstore.mapper.AuthenticationMapper;
import com.homeward.webstore.mapper.CartMapper;
import com.homeward.webstore.mapper.ItemMapper;
import com.homeward.webstore.common.util.RedisUtils;
import lombok.Data;
import lombok.experimental.Accessors;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.system.ApplicationHome;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Slf4j
@SpringBootTest
public class TestSpring {

    @Autowired
    private ItemMapper itemMapper;

    @Autowired
    private RedisUtils redisUtils;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private AuthenticationMapper authenticationMapper;

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
    @Disabled
    void testPropertyValue() {

    }

    @Test
    @Disabled
    void testRedisUtil() {
        boolean set = redisUtils.set("Ba1oretto", "{\"114514\":1}");
        System.out.println("set: " + set);

        Object get = redisUtils.get("Ba1oretto");
        System.out.println(get);

        boolean update = redisUtils.update("Ba1oretto", "{\"114514\":1919810}");
        System.out.println("update: " + update);

        boolean expire = redisUtils.setExpire("Ba1oretto", 10);
        System.out.println("expire: " + expire);

        long time1 = redisUtils.getExpire("Ba1oretto");
        System.out.println("time1: " + time1);

        boolean persist = redisUtils.persist("Ba1oretto");
        System.out.println("persist: " + persist);

        long time2 = redisUtils.getExpire("Ba1oretto");
        System.out.println("time2: " + time2);

        boolean delete = redisUtils.del("Ba1oretto");
        System.out.println("delete: " + delete);

        boolean hasKey = redisUtils.hasKey("Ba1oretto");
        System.out.println("hasKey: " + hasKey);
    }

    @Test
    @Disabled
    void testRedis() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1);
        userInfo.setName("jack");
        userInfo.setCreateTime(new Date());
        // 放入redis
        redisUtils.set("user", userInfo, 5);
        // 从redis中获取
        System.out.println("获取到数据：" + redisUtils.get("user") +
        "过期时间: " + redisUtils.getExpire("user"));
    }

    @Test
    @Disabled
    void testRedisValue() {
        System.out.println(redisUtils.get("Ba1oretto"));
    }

    @Test
    @Disabled
    void testJWT() {
        String token = JwtUtils.createToken("Ba1oretto");
        System.out.println(token);
        System.out.println(JwtUtils.verity());
    }

    @Test
    @Disabled
    void testStoreMapper() {
        List<ItemShowCaseInfo> itemsLists = itemMapper.getItemList("crates");
        itemsLists.forEach(System.out::println);
    }

    @Test
    @Disabled
    void testOrderMapper() {
        Float totalPrice = cartMapper.getTotalPrice("619377de9ada41388ef93dbf9fe56320");
        System.out.println(totalPrice);
    }

    @Test
    @Disabled
    void testStoreMapperGetItemId() {
        String itemId = itemMapper.getItemName(1);
        if (itemId == null) {
            System.out.println("0");
            return;
        }
        System.out.println(itemId);
    }

    @Test
    @Disabled
    void testOrderUpdateCart() {
        cartMapper.updateCart("619377de9ada41388ef93dbf9fe56320", 1000, 1);
    }

    @Test
    @Disabled
    void testOrderDeleteCart() {
        long l = cartMapper.deleteCart("619377de9ada41388ef93dbf9fe56320", 1001);
        System.out.println(l);
    }

    @Test
    @Disabled
    void testAuthMapperIsSingleCart() {
        List<Integer> integerList = authenticationMapper.itemIdList("619377de9ada41388ef93dbf9fe56320", 1000);
        if (integerList.contains(1000)) {
            System.out.println("1");
            return;
        }
        System.out.println("0");
    }

    @Test
    @Disabled
    void testApplicationContext() {
//        String applicationName = applicationContext.getApplicationName();
//        System.out.println(applicationName);
        ApplicationHome applicationHome = new ApplicationHome();
        File dir = applicationHome.getDir();
        System.out.println(dir.getPath());
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
