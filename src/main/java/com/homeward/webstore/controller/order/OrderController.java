package com.homeward.webstore.controller.order;

import com.homeward.webstore.service.interfaces.order.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/checkout")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("/packages/add/{commodityId}/single")
    public void create(@PathVariable("commodityId") Integer id, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        orderService.create(id, httpSession, request, response);
    }

    @PostMapping("/update")
    public void update(HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        orderService.update(httpSession, request, response);
    }
}
