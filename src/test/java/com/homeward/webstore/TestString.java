package com.homeward.webstore;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.homeward.webstore.VO.CrateResult;
import com.homeward.webstore.mapper.CountdownMapper;
import com.homeward.webstore.mapper.ItemsMapper;
import com.homeward.webstore.mapper.PriceMapper;
import com.homeward.webstore.pojo.Items;
import com.homeward.webstore.pojo.Subset.Countdown;
import com.homeward.webstore.pojo.Subset.Price;
import com.homeward.webstore.service.implement.StoreServiceImpl;
import com.homeward.webstore.service.interfaces.StoreService;
import com.homeward.webstore.util.JsonMap;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;
@SpringBootTest
public class TestString {

    @Autowired
    private ItemsMapper itemsMapper;

    @Autowired
    private PriceMapper priceMapper;

    @Autowired
    private CountdownMapper countdownMapper;

    @Autowired
    private StoreService storeService;

    @Test
    void testString() {
        Map<String, String> jsonMap = new JsonMap().getJsonMap("{\"name\":\"Ba1oretto\",\"id\":\"619377de9ada41388ef93dbf9fe56320\"}");
        System.out.println(jsonMap);
    }

    @Test
    void getItemList()
    {

    }
    @Test
    void testGetAll() {

        List<Items> itemsList = itemsMapper.findAll();
        System.out.println(itemsList);
        System.out.println(priceMapper.findAll());
        System.out.println(countdownMapper.findAll());


    }


    @Test
    void getPrice() {
        List<Items> itemsList = itemsMapper.findAll();
        CrateResult crateResult = new CrateResult();
        for (Items items : itemsList) {
            Integer itemId = items.getId();
            Price price = priceMapper.findPriceById(itemId);
            Countdown countdown = countdownMapper.findCountdownById(itemId);
            items.setPrice(price).setCountdown(countdown);
        }
        System.out.println(itemsList);
        }

    }
