package com.va.week10.controller;

import com.va.week10.MarketService;
import com.va.week10.model.Market;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/market")
public class MarketController {
    private final MarketService marketService;
    public MarketController(MarketService marketService){ this.marketService = marketService; }

    @PostMapping("/process")
    public Market processOrder(@Valid @RequestBody Market marketOrder) {
        return marketService.processMarketOrder(marketOrder);
    }

    @GetMapping("/all")
    public List<Market> getAllMarketOrders() { return marketService.getAllMarketOrders(); }
    
}
