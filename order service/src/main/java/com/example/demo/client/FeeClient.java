package com.example.demo.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.dto.OrderDTO;
import com.example.demo.dto.FeeDTO;

@FeignClient(name = "fee-service")
public interface FeeClient {
    @PostMapping("/api/fees/calc")
    FeeDTO calculateFees(@RequestBody OrderDTO order);
}
