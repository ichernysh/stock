package com.odessa.springboot.web;

import com.odessa.springboot.model.Stock;
import com.odessa.springboot.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/stocks")
public class StockController {

    @Autowired
    private StockService stockService;

    @RequestMapping(method = RequestMethod.GET)
    public Set<Stock> getStocks() {
        return stockService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}" )
    public Stock getStock(@PathVariable("id") long stockId){
        return stockService.find(stockId);
    }

    @RequestMapping(method = RequestMethod.PUT,  value = "/{id}")
    public Stock updateStockPrice(@PathVariable("id") long stockId,
                                  @RequestBody final Stock stock){
        return stockService.updatePrice(stockId, stock);
    }

    @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public Stock createStock(@RequestBody final Stock stock){
        return stockService.createStock(stock);
    }
}
