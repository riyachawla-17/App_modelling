package com.example.demo.repo;

import org.springframework.data.mongodb.repository.MongoRepository;
import com.example.demo.model.OrderEntity;

public interface OrderRepository extends MongoRepository<OrderEntity, String> { }
