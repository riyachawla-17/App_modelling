package com.va.week10.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.va.week10.dto.AcctTransaction;
import com.va.week10.dto.Fee;
import com.va.week10.dto.MarketOrder;
import com.va.week10.model.Order;
import com.va.week10.repository.OrderRepository;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepo;
    private final RestTemplate rest;
    private final ObjectMapper mapper;

    public OrderService(OrderRepository orderRepo, RestTemplate rest, ObjectMapper mapper) {
        this.orderRepo = orderRepo;
        this.rest = rest;
        this.mapper = mapper;
    }

    public Order placeOrder(Order order) {
        // 1) Save to Mongo
        Order saved = orderRepo.save(order);

        // 2) Try dynamic JSON via Eureka names
        MarketOrder quote = null;
        try {
            quote = rest.getForObject(
                "http://market-service/api/market/quote/{ticker}",
                MarketOrder.class, saved.getStockSymbol());
        } catch (Exception ignored) {
            // 2b) Fallback to static JSON file (meets assignment's "static json file" option)
            try {
                var res = new ClassPathResource("static/mock/market-" + saved.getStockSymbol() + ".json");
                if (res.exists()) quote = mapper.readValue(res.getInputStream(), MarketOrder.class);
            } catch (Exception e) { /* ignore */ }
        }

        // Fee from transaction-service; fallback to local calc if unavailable
        Fee fee;
        try {
            double amt = saved.getPrice() * saved.getQuantity();
            fee = rest.getForObject(
                "http://transaction-service/api/fee/calc?type={type}&amt={amt}",
                Fee.class, "BROKERAGE", amt);
        } catch (Exception e) {
            fee = new Fee();
            double base = Math.max(1.0, saved.getPrice() * saved.getQuantity() * 0.005);
            fee.setFeeSalesTax(base * 0.13);
            fee.setFeeAmt(base + fee.getFeeSalesTax());
            fee.setFeeType(true);
        }

        // 3) Build transaction + write JSON files (Jackson data binding)
        AcctTransaction txn = AcctTransaction.from(saved, quote, fee);
        writeJson("target/order-" + saved.getId() + ".json", saved);
        writeJson("target/txn-"   + saved.getId() + ".json", txn);

        return saved;
    }

    public List<Order> getAllOrders() { return orderRepo.findAll(); }

    private void writeJson(String filename, Object obj) {
        try {
            Path p = Path.of(filename);
            Files.createDirectories(p.getParent());
            mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filename), obj);
        } catch (Exception ignored) { }
    }
}
