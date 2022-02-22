package com.example.pizza_service.controller;

import com.example.pizza_service.dto.AddPizzaDto;
import com.example.pizza_service.dto.DisplayPizzaDto;
import com.example.pizza_service.dto.ToppingDispalyDto;
import com.example.pizza_service.model.Pizza;
import com.example.pizza_service.service.PizzaService;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/pizzas")
public class PizzaController {

    private final PizzaService pizzaService;

    public PizzaController(PizzaService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping()
    public Pizza add(@RequestBody AddPizzaDto pizza) {
        return pizzaService.add(pizza.getName(), pizza.getPrice(), pizza.getSize());
    }

    @GetMapping()
    public List<DisplayPizzaDto> getAll() {
        return pizzaService.getAll().stream().map(this::mapToDto).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public DisplayPizzaDto getById(@PathVariable long id) {
        return mapToDto(pizzaService.getById(id));
    }

    private DisplayPizzaDto mapToDto(Pizza pizza) {
        return new DisplayPizzaDto(pizza.getId(),
                pizza.getName(),
                pizza.getSize(),
                pizza.getPrice(),
                List.of(new ToppingDispalyDto(
                        22L, "Salamai", 5, BigDecimal.valueOf(.15), pizza.getName()
                ))
        );
    }
}
