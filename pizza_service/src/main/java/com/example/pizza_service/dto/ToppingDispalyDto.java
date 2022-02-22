package com.example.pizza_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ToppingDispalyDto {
    public Long id;
    public String name;
    public int weight;
    public BigDecimal price;
    public String pizza;
}
