package com.homeward.webstore.controller.order;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/checkout")
public class OrderController {

    @PostMapping("/packages/add/{commodityId}/single")
    public void increase(@PathVariable("commodityId") Integer id) {
    }
}
