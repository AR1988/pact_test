package com.example.pact_test.pact.model;

import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Topping {
    private long id;
    private String name;
    private String pizza;
    private double price;
    private int weight;
}
