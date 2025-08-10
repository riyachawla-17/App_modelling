package com.va.week10;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.va.week10.model.Market;
import com.va.week10.repository.MarketRepository;
import org.springframework.stereotype.Service;

import java.io.File;

@Service
public class MarketService {
    private final MarketRepository repo;
    private final ObjectMapper mapper;

    public MarketService(MarketRepository repo, ObjectMapper mapper) {
        this.repo = repo; this.mapper = mapper;
    }

    public Market processMarketOrder(Market m) {
       
        m.setLast(m.getAsk()); 
        m.setConfirmationStatus(Market.ConfirmationStatus.CONFIRMED);
        return repo.save(m);
    }

    public java.util.List<Market> getAllMarketOrders() { return repo.findAll(); }
}
