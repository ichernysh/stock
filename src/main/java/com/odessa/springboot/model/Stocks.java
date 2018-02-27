package com.odessa.springboot.model;

import lombok.Data;

import java.util.List;

@Data
public class Stocks {
    private List<Stock> stocks;
}
