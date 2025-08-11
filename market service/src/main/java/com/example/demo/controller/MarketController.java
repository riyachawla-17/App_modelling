package com.example.demo.controller;

import com.example.demo.dto.OrderDTO;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/market")
public class MarketController {

    // quick health check for Postman
    @GetMapping("/ping")
    public String ping() {
        return "market-service:OK";
    }

    // optional sample price lookup
    @GetMapping("/price/{ticker}")
    public String price(@PathVariable String ticker) {
        // stubbed price — replace with real data if you want
        return ticker.toUpperCase() + " price=210.50";
    }

    @PostMapping("/execute")
    public String execute(@Valid @RequestBody OrderDTO order){
        return "EXECUTED " + order.getOrderType() + " " + order.getQuantity() + " of " + order.getTickerSymbol();
    }
}
