package com.example.consumer.pact.service;

import com.example.consumer.pact.model.Pizza;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PizzaClient {

    private String defaultBackendURL = "http://localhost:8080";
    private HttpStatus responseStatusCode;

    /**
     * Change backend URL. Default ulr is: http://localhost:8080
     *
     * @param URLBase backend url
     */
    public void setURL(String URLBase) {
        this.defaultBackendURL = URLBase;
    }

    /**
     * @return one pizza
     */
    public Pizza getPizzaById(int pizzaId) {
        RestTemplate restTemplate = new RestTemplate();
        String url = defaultBackendURL + "/" + pizzaId;
        ResponseEntity<Pizza> response = restTemplate.getForEntity(url, Pizza.class);
        this.responseStatusCode = response.getStatusCode();
        return response.getBody();
    }

    /**
     * @return array of pizzas
     */
    public Pizza[] getPizzas() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Pizza[]> response = restTemplate.getForEntity(defaultBackendURL, Pizza[].class);
        this.responseStatusCode = response.getStatusCode();
        return response.getBody();
    }

    /**
     * @return response status
     */
    public HttpStatus getStatus() {
        return responseStatusCode;
    }

    public void resetStatusCode() {
        this.responseStatusCode = null;
    }
}
