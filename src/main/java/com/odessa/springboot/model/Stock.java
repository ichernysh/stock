package com.odessa.springboot.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public @AllArgsConstructor
class Stock {
    private long id;
    private String name;
    private double currentPrice;
    private long lastUpdate;
}
