package com.va.week10.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.va.week10.model.Order;
import com.va.week10.repository.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.File;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;
    private final ObjectMapper objectMapper;
    private final RestTemplate restTemplate;
    public OrderService(OrderRepository orderRepository,
                        ObjectMapper objectMapper,
                        Optional<RestTemplate> restTemplateOpt) {
        this.orderRepository = orderRepository;
        this.objectMapper = objectMapper;
        this.restTemplate = restTemplateOpt.orElse(null);
    }

    public Order placeOrder(Order order) throws Exception {
        Order saved = orderRepository.save(order);
        File out = new File("target/handoff/order-latest.json");
        out.getParentFile().mkdirs();
        objectMapper.writerWithDefaultPrettyPrinter().writeValue(out, saved);
        return saved;
    }

   public Order placeAndSendToMarket(Order order) throws Exception {
        Order saved = placeOrder(order); // saves + writes JSON file

        if (restTemplate != null) {
            Map<String, Object> payload = Map.of(
                    "stockSymbol", saved.getStockSymbol(),
                    "quantity", saved.getQuantity()
            );
            restTemplate.postForEntity("http://localhost:8082/market/process", payload, Void.class);
        }
        return saved;
    }

    public java.util.List<Order> getAll() {
        return orderRepository.findAll();
    }

    public Optional<Order> getById(String id) {
        return orderRepository.findById(id);
    }
}
