package com.homeward.webstore.controller.order;

import com.homeward.webstore.service.interfaces.order.OrderService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

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
    public void update(@RequestParam Map<String, String> map, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        orderService.update(map, httpSession, request, response);
    }

    @PostMapping("/packages/remove/{commodityId}")
    public void remove(@PathVariable("commodityId")  Integer id, HttpSession httpSession, HttpServletRequest request, HttpServletResponse response) {
        orderService.remove(id, httpSession, request, response);
    }
}