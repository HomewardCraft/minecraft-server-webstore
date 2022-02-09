package com.homeward.webstore;

import com.homeward.webstore.mapper.CountdownMapper;
import com.homeward.webstore.mapper.ItemsMapper;
import com.homeward.webstore.mapper.PriceMapper;
import com.homeward.webstore.pojo.Subset.Countdown;
import com.homeward.webstore.pojo.Subset.Price;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TestString {
    @Autowired
    private PriceMapper priceMapper;
    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private CountdownMapper countdownMapper;
    @Test
    void baioretto() {
        List<Price> price = priceMapper.selectList(null);
        List<Countdown> countdown = countdownMapper.selectList(null);
        System.out.println(price);
        System.out.println(countdown);
    }

}
