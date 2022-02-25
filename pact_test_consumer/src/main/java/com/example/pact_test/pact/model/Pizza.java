package com.example.pact_test.pact.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class Pizza {
    private long id;
    private String name;
    private double price;
    private int size;
    private List<Topping> toppings;

    /**
     * need for parser.
     */
    public Pizza() {
        this.toppings = new ArrayList<>();
    }
}
