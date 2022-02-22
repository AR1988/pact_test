package com.example.pizza_service.service;

import com.example.pizza_service.model.Pizza;
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
        return pizzaRepository.findById(id).orElse(new Pizza());
    }

    public List<Pizza> getAll() {
        return new ArrayList<>(pizzaRepository.findAll());
    }

    public Pizza add(String name, BigDecimal price, Integer size) {
        return pizzaRepository.save(new Pizza(name, size, price));
    }
}
