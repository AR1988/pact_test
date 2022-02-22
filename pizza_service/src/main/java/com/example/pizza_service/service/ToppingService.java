package com.example.pizza_service.service;

import com.example.pizza_service.repo.ToppingRepository;
import org.springframework.stereotype.Service;

@Service
public class ToppingService {

    private final ToppingRepository toppingRepository;

    public ToppingService(ToppingRepository toppingRepository) {
        this.toppingRepository = toppingRepository;
    }
}
