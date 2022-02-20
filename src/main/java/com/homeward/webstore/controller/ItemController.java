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
     * 返回所有的Crate类型的商品Json
     *
     * @return CrateResult
     */
    @GetMapping("/{items}")
    public R getSpecificItems(@PathVariable("items") String type) {
        List<ItemInfoBO> itemsLists = itemService.getSpecificItems(type);
        return R.ok(itemsLists);
    }



}