package com.example.pizza_service.dto;

import com.example.pizza_service.model.Topping;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DisplayPizzaDto {
    private long id;
    private String name;
    private int size;
    private BigDecimal price;
    List<ToppingDispalyDto> toppings;
}
