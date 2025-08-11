package com.example.demo.controller;

import com.example.demo.client.FeeClient;
import com.example.demo.client.MarketClient;
import com.example.demo.dto.FeeDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.model.OrderEntity;
import com.example.demo.repo.OrderRepository;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderRepository repo;
    private final FeeClient feeClient;
    private final MarketClient marketClient;

    public OrderController(OrderRepository repo, FeeClient feeClient, MarketClient marketClient){
        this.repo = repo;
        this.feeClient = feeClient;
        this.marketClient = marketClient;
    }

    @PostMapping
    public ResponseEntity<String> place(@Valid @RequestBody OrderDTO dto){
        // persist basic order
        OrderEntity e = new OrderEntity();
        e.setTickerSymbol(dto.getTickerSymbol());
        e.setQuantity(dto.getQuantity());
        e.setOrderPrice(dto.getOrderPrice());
        e.setOrderType(dto.getOrderType());
        repo.save(e);

        // call fee-service
        FeeDTO fees = feeClient.calculateFees(dto);

        // call market-service
        String exec = marketClient.execute(dto);

        String msg = "ORDER OK. Market: " + exec + " | Fees: $" + fees.getFeeAmt();
        return ResponseEntity.ok(msg);
    }
}
