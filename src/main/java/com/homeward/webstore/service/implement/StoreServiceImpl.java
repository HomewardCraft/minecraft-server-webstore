package com.homeward.webstore.service.implement;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.homeward.webstore.mapper.CountdownMapper;
import com.homeward.webstore.pojo.Items;
import com.homeward.webstore.pojo.Subset.Countdown;
import com.homeward.webstore.pojo.Subset.Price;
import com.homeward.webstore.VO.StoreResult;
import com.homeward.webstore.mapper.ItemsMapper;
import com.homeward.webstore.mapper.PriceMapper;
import com.homeward.webstore.service.interfaces.StoreService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public StoreResult getSpecificItems(String type, StoreResult storeResult) {
        /* List<Items> itemsList = itemsMapper.findAll(); */
        QueryWrapper<Items> itemsQueryWrapper = new QueryWrapper<>();
        /* 加条件, 使查询指定类型 crates? extras?, 并且这个属性并不会被查询, 详见pojo的items下的这个属性 */
        itemsQueryWrapper.eq("type", type);
        /* 使用mybatis plus进行查询全部操作 */
        List<Items> itemsList = itemsMapper.selectList(itemsQueryWrapper);
        Price price = priceMapper.selectById(null);
        Countdown countdown = countdownMapper.selectById(null);
        for (Items items : itemsList) {
            Integer itemId = items.getId();

            items.setPrice(price).setCountdown(countdown);
        }
        return storeResult.setPackages(itemsList);
    }
}
