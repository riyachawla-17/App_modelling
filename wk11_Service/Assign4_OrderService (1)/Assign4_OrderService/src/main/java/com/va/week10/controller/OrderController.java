package com.va.week10.controller;

import com.va.week10.model.Order;
import com.va.week10.service.OrderService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService service;
    public OrderController(OrderService service) { this.service = service; }

    @PostMapping("/place")
    public ResponseEntity<?> placeOrder(@Valid @RequestBody Order order, BindingResult br) {
        if (br.hasErrors()) {
            Map<String, String> errors = br.getFieldErrors().stream()
                .collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
            return ResponseEntity.badRequest().body(errors);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.placeOrder(order));
    }

    @GetMapping
    public List<Order> getAllOrders() {
        return service.getAllOrders();
    }
}
