package com.homeward.webstore.controller;

import com.homeward.webstore.VO.CrateResult;
import com.homeward.webstore.service.interfaces.StoreService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@CrossOrigin
@RequestMapping("/c")

public class StoreController {

    private final StoreService storeService;


    public StoreController(StoreService storeService) {
        this.storeService = storeService;
    }

    //宝箱列表的Controller

    /**
     *  返回所有的Crate类型的商品Json
     *  @return JsonResult
     */

    @GetMapping("/crates")
    public CrateResult getCrateItems(CrateResult crateResult) {
        CrateResult crateItems = storeService.getCrateItems(crateResult);
        crateItems.setIsError(false).setName("Crates").setDescription("").setDisplay("List");
        return crateItems;
    }


}
