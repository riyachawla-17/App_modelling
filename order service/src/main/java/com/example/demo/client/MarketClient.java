package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.dto.OrderDTO;

@FeignClient(name = "market-service")
public interface MarketClient {
    @PostMapping("/api/market/execute")
    String execute(@RequestBody OrderDTO order);
}
