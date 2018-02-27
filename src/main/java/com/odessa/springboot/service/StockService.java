package com.odessa.springboot.service;

import com.odessa.springboot.model.Stock;
import com.odessa.springboot.persistence.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Set;

@Service
public class StockService {
    @Autowired
    private StockRepository repository;

    public Set<Stock> findAll() {
        return repository.findAll();
    }

    public Stock find(long stockId) {
        return repository.find(stockId);
    }

    public Stock updatePrice(long stockId, Stock stock) {
        return repository.update(stockId, stock);
    }

    public Stock createStock(Stock stock) {
        stock.setLastUpdate(Calendar.getInstance().getTime().getTime());
        return repository.add(stock);
    }

}
