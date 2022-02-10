package com.homeward.webstore;

import com.homeward.webstore.mapper.StoreMapper;
import com.homeward.webstore.pojo.packages.ItemsList;
import com.homeward.webstore.util.FixedJsonUtil;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;

@SpringBootTest
public class TestString {

    @Autowired
    private StoreMapper storeMapper;

    @Test
    void concat() {
        List<ItemsList> itemsList= storeMapper.getStoreItems("crates");
        List<String> list = new ArrayList<>();
        for (ItemsList items : itemsList) {
            String s = items.toString();
            String replace = s.replace("id=null, ", "");
            list.add(replace);
        }
        List<String> list1 = FixedJsonUtil.fixedFormat(list, String.class);
        System.out.println(list1);
    }
}
