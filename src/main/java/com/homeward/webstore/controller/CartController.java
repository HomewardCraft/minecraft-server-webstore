package com.homeward.webstore.controller;

import com.homeward.webstore.vo.R;
import com.homeward.webstore.aop.annotations.JoinPointSymbol;
import com.homeward.webstore.service.cart.CartService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("/insert/{itemId}")
    @JoinPointSymbol
    public R insert(@PathVariable("itemId") Integer id, HttpServletRequest request) {
        cartService.insertCart(id, request);
        return R.ok();
    }

    @PostMapping("/update")
    @JoinPointSymbol
    public R update(@RequestParam Map<String, String> map, HttpServletRequest request) {
        cartService.updateCart(map, request);
        return R.ok();
    }

    @PostMapping("/delete/{itemId}")
    @JoinPointSymbol
    public R delete(@PathVariable("itemId") Integer id, HttpServletRequest request) {
        cartService.deleteCart(id, request);
        return R.ok();
    }

    @PostMapping("/commit")
    public R commit() {
        Float totalPrice = cartService.commit();
        return R.ok(totalPrice);
    }
}