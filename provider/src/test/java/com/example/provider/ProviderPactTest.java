package com.example.provider;

import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import au.com.dius.pact.provider.junitsupport.target.Target;
import au.com.dius.pact.provider.junitsupport.target.TestTarget;
import au.com.dius.pact.provider.spring.SpringRestPactRunner;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@RunWith(SpringRestPactRunner.class)
@SpringBootTest
@Provider("Pizza-Service")
@PactBroker
public class ProviderPactTest {

    private final String API_HOST = "localhost";
    private final int API_PORT = 8080;

    @TestTarget
    public final Target target = new HttpTarget(API_HOST, API_PORT);

    @State("get all pizzas")
    public void getAll() {
        System.out.println();
    }

    @State("get by ID 1 exist")
    public void getById1() {
        System.out.println();
    }
}
