package com.example.consumer.pact.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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
