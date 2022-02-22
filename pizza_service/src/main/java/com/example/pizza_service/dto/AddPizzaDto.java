package com.example.pizza_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AddPizzaDto {
    private String name;
    private Integer size;
    private BigDecimal price;
}
