package com.homeward.webstore.controller;

import com.homeward.webstore.java.bean.BO.ItemInfoBO;
import com.homeward.webstore.java.bean.VO.R;
import com.homeward.webstore.service.store.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//宝箱列表的Controller
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/category")
@ResponseBody
public class StoreController {
    private final StoreService storeService;

    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }


    /**
     * 返回所有的Crate类型的商品Json
     *
     * @return CrateResult
     */
    @GetMapping("/{items}")
    public R getSpecificItems(@PathVariable("items") String type) {
        List<ItemInfoBO> itemsLists = storeService.getSpecificItems(type);
        return R.ok(itemsLists);
    }



}