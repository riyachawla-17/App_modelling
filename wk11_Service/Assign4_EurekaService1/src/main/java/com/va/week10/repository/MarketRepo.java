package com.va.week10.repository;

import com.va.week10.model.Market;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MarketRepo extends MongoRepository<Market, String> {
}
