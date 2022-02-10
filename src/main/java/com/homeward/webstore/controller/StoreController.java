package com.homeward.webstore.controller;

import com.alibaba.fastjson.JSONObject;
import com.homeward.webstore.VO.StoreResult;
import com.homeward.webstore.pojo.store.Items;
import com.homeward.webstore.service.interfaces.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//宝箱列表的Controller
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/category")
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
    public StoreResult getSpecificItems(@PathVariable("items") String type) {
        List<Items> crateItems = storeService.getSpecificItems(type);
        return StoreResult.success(type, "", "list", crateItems);
    }
}