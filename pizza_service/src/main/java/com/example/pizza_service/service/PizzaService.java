package com.example.pizza_service.service;

import com.example.pizza_service.model.Pizza;
import com.example.pizza_service.model.Topping;
import com.example.pizza_service.repo.PizzaRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaService {

    private final PizzaRepository pizzaRepository;

    public PizzaService(PizzaRepository pizzaRepository) {
        this.pizzaRepository = pizzaRepository;
    }

    public Pizza getById(Long id) {
        if (id == 1)
            return new Pizza(99L, "Margarita", 6, BigDecimal.valueOf(9.09), new ArrayList<>());
        return pizzaRepository.findById(id).orElse(new Pizza());
    }

    public List<Pizza> getAll() {
//        return new ArrayList<>(pizzaRepository.findAll());
        Pizza pizza = new Pizza(989L, "Margarita", 6, BigDecimal.valueOf(9.09), new ArrayList<>());
        Topping topping = new Topping(1212L, "Tomato", 5, BigDecimal.valueOf(0.05), pizza);
        pizza.setToppings(List.of(topping));


        return List.of(pizza);
    }

    public Pizza add(String name, BigDecimal price, Integer size) {
        return pizzaRepository.save(new Pizza(name, size, price));
    }
}
