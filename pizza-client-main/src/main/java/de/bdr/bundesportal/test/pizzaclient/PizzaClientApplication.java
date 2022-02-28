package de.bdr.bundesportal.test.pizzaclient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableFeignClients
@EnableScheduling
public class PizzaClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(PizzaClientApplication.class, args);
    }

}
