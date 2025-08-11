package com.example.demo.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fees")
public class FeesController {

    @GetMapping("/calculate")
    public double calculateFee(@RequestParam double amount) {
        return amount * 0.01;  // 1% fee
    }
}
