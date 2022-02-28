package com.example.pizza_service.controller;

import com.example.pizza_service.dto.ToppingAddDto;
import com.example.pizza_service.dto.ToppingDispalyDto;
import com.example.pizza_service.model.Topping;
import com.example.pizza_service.service.ToppingService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/topping")
public class ToppingController {

    private final ToppingService pizzaService;

    public ToppingController(ToppingService pizzaService) {
        this.pizzaService = pizzaService;
    }

    @PostMapping()
    public Topping add(@RequestBody ToppingAddDto topping) {
        return new Topping();
    }

    @GetMapping()
    public List<ToppingDispalyDto> getAll() {
        return List.of();
    }

    @GetMapping("/{id}")
    public ToppingDispalyDto getById(@PathVariable long id) {
        return new ToppingDispalyDto();
    }

    private ToppingDispalyDto mapToDto(Topping topping) {
        return new ToppingDispalyDto(topping.getId(),
                topping.getName(),
                topping.getWeight(),
                topping.getPrice(),
                topping.getPizza().getId());
    }
}
