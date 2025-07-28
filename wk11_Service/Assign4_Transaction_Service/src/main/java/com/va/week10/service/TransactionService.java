package com.va.week10.service;

import com.va.week10.model.Transaction;
import com.va.week10.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    private final TransactionRepository repo;

    public TransactionService(TransactionRepository repo) {
        this.repo = repo;
    }

    public Transaction saveTransaction(Transaction transaction) {
        return repo.save(transaction);
    }

    public List<Transaction> getAllTransactions() {
        return repo.findAll();
    }
}
