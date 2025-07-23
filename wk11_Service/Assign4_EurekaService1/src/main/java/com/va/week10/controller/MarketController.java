package com.va.week10.controller;

import com.va.week10.MarketService;
import com.va.week10.model.Market;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {

    @Autowired
    private MarketService marketService;

    // POST /market/process - Process a new market order
    @PostMapping("/process")
    public Market processOrder(@RequestBody Market marketOrder) {
        return marketService.processMarketOrder(marketOrder);
    }

    // GET /market/all - Fetch all market orders
    @GetMapping("/all")
    public List<Market> getAllMarketOrders() {
        return marketService.getAllMarketOrders();
    }
}
