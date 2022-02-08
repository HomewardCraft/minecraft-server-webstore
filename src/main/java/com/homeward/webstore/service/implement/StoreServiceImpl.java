package com.homeward.webstore.service.implement;

import com.homeward.webstore.mapper.CountdownMapper;
import com.homeward.webstore.pojo.Items;
import com.homeward.webstore.pojo.Subset.Countdown;
import com.homeward.webstore.pojo.Subset.Price;
import com.homeward.webstore.VO.CrateResult;
import com.homeward.webstore.mapper.ItemsMapper;
import com.homeward.webstore.mapper.PriceMapper;
import com.homeward.webstore.service.interfaces.StoreService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreServiceImpl implements StoreService {
    private final PriceMapper priceMapper;
    private final ItemsMapper itemsMapper;
    private final CountdownMapper countdownMapper;

    public StoreServiceImpl(PriceMapper priceMapper, ItemsMapper itemsMapper, CountdownMapper countdownMapper) {
        this.priceMapper = priceMapper;
        this.itemsMapper = itemsMapper;
        this.countdownMapper = countdownMapper;
    }

    @Override
    public CrateResult getCrateItems(CrateResult crateResult) {
        List<Items> itemsList = itemsMapper.findAll();
        for (Items items : itemsList) {
            Integer itemId = items.getId();
            Price price = priceMapper.findPriceById(itemId);
            Countdown countdown = countdownMapper.findCountdownById(itemId);
            items.setPrice(price).setCountdown(countdown);
        }
        return crateResult.setPackages(itemsList);
    }
}
