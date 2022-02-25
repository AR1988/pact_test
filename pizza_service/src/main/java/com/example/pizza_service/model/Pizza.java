package com.example.pizza_service.model;

import lombok.*;

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
    @Setter
    private String name;
    @Setter
    private Integer size;
    @Setter
    private BigDecimal price;

    @Setter
    @OneToMany(mappedBy = "pizza")
    private List<Topping> toppings;

    public Pizza(String name, Integer size, BigDecimal price) {
        this.name = name;
        this.size = size;
        this.price = price;
    }
}
