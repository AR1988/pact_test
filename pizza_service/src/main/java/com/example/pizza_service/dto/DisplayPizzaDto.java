package com.example.pizza_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DisplayPizzaDto {
    private long id;
    private String name;
    private int size;
    private BigDecimal price;
    List<ToppingDispalyDto> toppings;
}
