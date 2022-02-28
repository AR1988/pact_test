package de.bdr.bundesportal.test.pizzaclient;

import de.bdr.bundesportal.test.pizzaclient.domain.Pizza;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "PizzaServiceClient", url = "http://localhost:8080/api/v1")
public interface PizzaServiceClient {

    @GetMapping("/pizzas/")
    List<Pizza> getPizzas(@RequestParam(value = "limit", required = false) Integer limit);

    @GetMapping("/pizzas/{id}")
    Pizza getPizzasById(@PathVariable int id);

//    @GetMapping("/toppings/")
//    List<Topping> getToppings(@RequestParam(value = "limit", required = false) Integer limit);

    @PostMapping("/pizzas/")
    Pizza composePizza(Pizza pizza);
}
