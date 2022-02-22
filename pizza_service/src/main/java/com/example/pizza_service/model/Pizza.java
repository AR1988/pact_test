package com.example.pizza_service.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Pizza {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Integer size;
    private BigDecimal price;

    public Pizza(String name, Integer size, BigDecimal price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }

    @OneToMany(mappedBy = "pizza")
    private List<Topping> toppings;
}
