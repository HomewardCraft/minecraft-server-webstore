package com.homeward.webstore.controller;

import com.homeward.webstore.java.bean.BO.ItemInfoBO;
import com.homeward.webstore.java.bean.VO.R;
import com.homeward.webstore.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//宝箱列表的Controller
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/category")
@ResponseBody
public class ItemController {
    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }


    /**
     * 返回所有的特定类型的商品Json
     *
     * @return CrateResult
     */
    @GetMapping("/{itemCategory}")
    public R getItemList(@PathVariable("itemCategory") String type) {
        List<ItemInfoBO> itemList = itemService.getItemList(type);
        return R.ok(itemList);
    }

    /**
     * 返回的特定类型特定id的商品的Json
     *
     * @return CrateResult
     */
    @GetMapping("/{itemCategory}/{itemId}")
    public R getSpecificItem(@PathVariable("itemCategory") String category, @PathVariable("itemId") Integer id) {
        ItemInfoBO itemsLists = itemService.getSpecificItem(category, id);
        return R.ok(itemsLists);
    }
}