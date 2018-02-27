package com.odessa.springboot.persistence;

import com.odessa.springboot.model.Stock;
import org.springframework.stereotype.Repository;

import java.util.Calendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@Repository
public class StockRepository {

    private final Map<Long, Stock> stocksMap = new HashMap<>();

    public StockRepository() {
        long timestamp = Calendar.getInstance().getTime().getTime();
        stocksMap.put(1L, new Stock(1, "stock_1", 100.00, timestamp));
        stocksMap.put(2L, new Stock(2, "stock_2", 200.00, timestamp));
        stocksMap.put(3L, new Stock(3, "stock_3", 300.00, timestamp));
        stocksMap.put(4L, new Stock(4, "stock_4", 400.00, timestamp));
        stocksMap.put(5L, new Stock(5, "stock_5", 500.00, timestamp));
    }

    public Set<Stock> findAll() {
        return new HashSet<>(stocksMap.values());
    }

    public Stock find(long stockId) {
        return stocksMap.get(stockId);
    }

    public Stock update(long stockId, Stock stock) {
        return stocksMap.put(stockId, stock);
    }

    public Stock add(Stock stock) {
        stock.setId(stocksMap.size() + 1);
        return stocksMap.put(stock.getId(), stock);
    }
}
