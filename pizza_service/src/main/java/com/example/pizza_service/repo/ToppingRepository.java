package com.example.pizza_service.repo;

import com.example.pizza_service.model.Topping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToppingRepository extends JpaRepository<Topping, Long> {
}
