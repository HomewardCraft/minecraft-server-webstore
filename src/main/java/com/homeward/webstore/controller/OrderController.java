package com.homeward.webstore.controller;

import com.homeward.webstore.VO.R;
import com.homeward.webstore.service.order.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
    public R insert(@PathVariable("itemId") Integer id, HttpServletRequest request, HttpServletResponse response) {
        orderService.insertCart(id, request, response);
        return R.ok();
    }

    @PostMapping("/update")
    public R update(@RequestParam Map<String, String> map, HttpServletRequest request) {
        orderService.updateCart(map, request);
        return R.ok();
    }

    @PostMapping("/delete/{itemId}")
    public R delete(@PathVariable("itemId") Integer id, HttpServletRequest request, HttpServletResponse response) {
        orderService.deleteCart(id, request, response);
        return R.ok();
    }

    @PostMapping("/commit")
    public R commit() {
        Float totalPrice = orderService.commit();
        return R.ok(totalPrice);
    }
}