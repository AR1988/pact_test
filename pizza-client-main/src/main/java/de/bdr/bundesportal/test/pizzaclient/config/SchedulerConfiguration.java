package de.bdr.bundesportal.test.pizzaclient.config;

import de.bdr.bundesportal.test.pizzaclient.PizzaServiceClient;
import de.bdr.bundesportal.test.pizzaclient.domain.Pizza;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@Slf4j
public class SchedulerConfiguration {
    private PizzaServiceClient pizzaServiceClient;

    public SchedulerConfiguration(PizzaServiceClient pizzaServiceClient) {
        this.pizzaServiceClient = pizzaServiceClient;
    }

    @Scheduled(fixedDelay = 30 * 1000)
    public void callPizzaService() {
        try {
            final List<Pizza> pizzas = pizzaServiceClient.getPizzas(12);

            int pizzaId = 1;
            final Pizza pizzaByID1 = pizzaServiceClient.getPizzasById(pizzaId);

            log.info("Obtained {} pizzas", pizzas.size());
            log.info("Obtained {} pizza by id" + pizzaId, pizzaByID1.toString());
        } catch (Exception e) {
            //We don't need to retry our operation, as this job re-occurs every n seconds
            log.error("Error obtaining Pizzas!", e);
        }
    }
}
