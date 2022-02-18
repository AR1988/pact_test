package com.example.pact_test.pact.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Topping {
    private Long id;
    private String name;
    private String pizza;
    private BigDecimal price;
    private int weight;
}
