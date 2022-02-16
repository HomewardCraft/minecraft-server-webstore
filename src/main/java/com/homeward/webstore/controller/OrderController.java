package com.homeward.webstore.controller;

import com.homeward.webstore.VO.R;
import com.homeward.webstore.service.order.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/insert/{itemId}")
    public R insert(@PathVariable("itemId") Integer id) {
        orderService.insertCart(id);
        return R.ok();
    }

    @PostMapping("/update")
    public R update(@RequestParam Map<String, String> map) {
        orderService.updateCart(map);
        return R.ok();
    }

    @PostMapping("/delete/{itemId}")
    public R delete(@PathVariable("itemId") Integer id) {
        orderService.deleteCart(id);
        return R.ok();
    }

    @PostMapping("/commit")
    public R commit() {
        Float totalPrice = orderService.commit();
        return R.ok(totalPrice);
    }
}