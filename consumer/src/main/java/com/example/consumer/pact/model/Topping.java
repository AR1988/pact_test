package com.example.consumer.pact.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
