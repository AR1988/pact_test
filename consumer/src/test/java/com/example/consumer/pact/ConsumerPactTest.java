package com.example.consumer.pact;

import au.com.dius.pact.consumer.dsl.DslPart;
import au.com.dius.pact.consumer.dsl.PactDslJsonArray;
import au.com.dius.pact.consumer.dsl.PactDslJsonBody;
import au.com.dius.pact.consumer.dsl.PactDslWithProvider;
import au.com.dius.pact.consumer.junit.PactProviderRule;
import au.com.dius.pact.consumer.junit.PactVerification;
import au.com.dius.pact.core.model.RequestResponsePact;
import au.com.dius.pact.core.model.annotations.Pact;
import com.example.consumer.pact.model.Pizza;
import com.example.consumer.pact.service.PizzaClient;
import lombok.extern.slf4j.Slf4j;
import org.junit.Rule;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ConsumerPactTest {

    @Autowired
    private PizzaClient client;

    @Rule
    public PactProviderRule mockProvider = new PactProviderRule("Pizza-Service", this);

    @BeforeEach
    public void initState() {
        client.resetStatusCode();
    }

    /**
     * Contract Test between Provider and Consumer<br>
     * get list of pizzas<br>
     * <pre>
     * json body like:
     * [
     *   {
     *     "name": "Pizza Salami",
     *     "id": 1,
     *     "size": 8,
     *     "price": 9.99,
     *     "toopings": [
     *       {
     *         "name": "Salami",
     *         "pizza": "Pizza Salami",
     *         "weight": 10,
     *         "price": 0.15,
     *         "id": 10
     *       }
     *     ]
     *   }
     * ]
     * </pre>
     */
    @Pact(consumer = "FrontendApplication", provider = "Pizza-Service")
    public RequestResponsePact createPactGetAll(PactDslWithProvider builder) {

        DslPart bodyPizzasList = PactDslJsonArray
                .arrayEachLike()
                            .id("id", 1L)
                            .stringType("name", "Pizza Salami")
                            .numberType("size", 8)
                            .decimalType("price", 9.99)
                                 .eachLike("toppings")
                                        .id("id", 10L)
                                        .stringType("name", "Salami")
                                        .stringType("pizza", "Pizza Salami")
                                        .numberType("weight", 10)
                                        .decimalType("price", 0.15)
                                .closeArray()
                .closeObject();

        log.info("List of pizzas, json body: " + bodyPizzasList);

        return builder
                .given("get all pizzas")
                .uponReceiving("get all pizzas")
                .path("/api/v1/pizzas")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(bodyPizzasList)
                .toPact();
    }

    /**
     * Contract Test between Provider and Consumer<br>
     * get pizza by id 22
     * <pre>
     *     json body like:
     *     {
     *     "name": "Pizza Bacon",
     *     "id": 22,
     *     "size": 11,
     *     "price": 8.99,
     *     "toopings": [
     *       {
     *         "name": "Salami",
     *         "pizza": "Pizza Salami",
     *         "weight": 10,
     *         "price": 0.15,
     *         "id": 22
     *       }
     *     ]
     *   }
     * </pre>
     */
    @Pact(consumer = "FrontendApplication", provider = "Pizza-Service")
    public RequestResponsePact createPactGetById1(PactDslWithProvider builder) {

        PactDslJsonBody bodyPizzaById = new PactDslJsonBody();
        bodyPizzaById
                .stringType("name", "Pizza Bacon")
                .id("id", 1L)
                .numberType("size", 11)
                .decimalType("price", 8.99)

                .eachLike("toppings")
                .id("id", 22L)
                .stringType("name", "Bacon")
                .stringType("pizza", "Pizza Bacon")
                .numberType("weight", 4)
                .decimalType("price", 0.05)

                .closeArray();

        log.info("Pizza with id 1, json body: " + bodyPizzaById);

        return builder
                .given("get by ID 1 exist")
                .uponReceiving("get pizza by ID 1")
                .path("/api/v1/pizzas/1")
                .method("GET")
                .willRespondWith()
                .status(200)
                .body(bodyPizzaById)
                .toPact();
    }

    @Test
    @PactVerification(value = "Pizza-Service", fragment = "createPactGetAll")
    public void getPizzas() {
        client.setURL(mockProvider.getUrl() + "/api/v1//pizzas");
        Pizza[] pizzas = client.getPizzas();

        assertEquals(1, pizzas.length);
        Pizza pizzaFromList = pizzas[0];
        assertEquals("Pizza Salami", pizzaFromList.getName());
        assertEquals(9.99, pizzaFromList.getPrice());
        assertEquals(1L, pizzaFromList.getId());

        assertEquals(1, pizzaFromList.getToppings().size());
        assertEquals(10, pizzaFromList.getToppings().get(0).getId());
    }

    @Test
    @PactVerification(value = "Pizza-Service", fragment = "createPactGetById1")
    public void runGetPizzaById1_pizzaExist() {
        client.setURL(mockProvider.getUrl() + "/api/v1//pizzas");

        Pizza pizza = client.getPizzaById(1);
        HttpStatus httpStatus = client.getStatus();

        assertEquals(HttpStatus.OK, httpStatus);

        assertNotNull(pizza);
        assertEquals("Pizza Bacon", pizza.getName());
        assertEquals(8.99, pizza.getPrice());
        assertEquals(1L, pizza.getId());

        assertEquals(1, pizza.getToppings().size());
        assertEquals(22, pizza.getToppings().get(0).getId());
    }
}
