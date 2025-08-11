package com.example.demo.controller;

import com.example.demo.dto.FeeDTO;
import com.example.demo.dto.OrderDTO;
import com.example.demo.model.FeeEntity;
import com.example.demo.repo.FeeRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import java.math.BigDecimal;

@RestController
@RequestMapping("/api/fees")
public class FeeController {

    private final FeeRepository repo;
    public FeeController(FeeRepository repo){ this.repo = repo; }

    @PostMapping("/calc")
    public FeeDTO calc(@Valid @RequestBody OrderDTO order){
        // simple fee model
        BigDecimal tradeAmt = order.getOrderPrice().multiply(BigDecimal.valueOf(order.getQuantity()));
        BigDecimal commission = tradeAmt.multiply(new BigDecimal("0.0015")); // 0.15%
        BigDecimal ecn = new BigDecimal("0.005").multiply(BigDecimal.valueOf(order.getQuantity()));
        BigDecimal subtotal = commission.add(ecn);
        BigDecimal tax = subtotal.multiply(new BigDecimal("0.13"));
        BigDecimal total = subtotal.add(tax);

        // persist
        FeeEntity fe = new FeeEntity();
        fe.setTotal(total); fe.setSalesTax(tax);
        repo.save(fe);

        // respond
        FeeDTO dto = new FeeDTO();
        dto.setFeeType(FeeDTO.FeeType.TOTAL);
        dto.setFeeSalesTax(tax);
        dto.setFeeAmt(total);
        return dto;
    }
}
