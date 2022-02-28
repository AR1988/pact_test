package de.bdr.bundesportal.test.pizzaclient.domain;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class Topping {
    private Long id;
    private String name;
    private int weight;
    private BigDecimal price;
    private Long pizzaId;
}
