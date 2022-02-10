package com.homeward.webstore;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.mapper.StoreMapper;
import com.homeward.webstore.pojo.store.Items;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestString {

    @Autowired
    private StoreMapper storeMapper;

    @Test
    void concat() {
        List<Items> crates = storeMapper.getStoreItems("crates");
        String s = JSONObject.toJSONString(crates);
        String replace = s.replace("\"", "");
        System.out.println(JSONObject.parse(replace).toString());
    }
}
