package com.homeward.webstore.controller;

import com.homeward.webstore.VO.StoreResult;
import com.homeward.webstore.service.interfaces.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

//宝箱列表的Controller
@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/c")
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
    public StoreResult getSpecificItems(@PathVariable("items") String type, StoreResult storeResult) {
        StoreResult crateItems = storeService.getSpecificItems(type, storeResult);
        /* ↓如果不用这个返回会抛请求头过大的异常, 为什么用了这个就不抛了, 优质解答为我不知道
         * ↓success(name, description, display, object) */
        return StoreResult.success(type, "", "list", crateItems);
    }
}