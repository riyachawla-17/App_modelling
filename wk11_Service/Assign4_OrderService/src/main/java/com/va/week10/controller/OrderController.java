package com.va.week10.controller;
import com.va.week10.model.Order;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import com.va.week10.service.OrderService;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;
    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @PostMapping
    public Order placeOrder(@Valid @RequestBody Order order) throws Exception {
        return orderService.placeOrder(order);
    }

    @PostMapping("/place-and-send")
    public Order placeAndSend(@Valid @RequestBody Order order) throws Exception {
        return orderService.placeAndSendToMarket(order);
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.getAll();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable String id) {
        return orderService.getById(id).orElse(null);
    }
}
