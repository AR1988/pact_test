package de.bdr.bundesportal.test.pizzaclient.domain;

import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class Pizza {
    private long id;
    private String name;
    private Integer size;
    private BigDecimal price;
    private List<Topping> toppings;
}
