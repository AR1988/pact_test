package com.example.pact_test_provider;

import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactFolder;
import au.com.dius.pact.provider.junitsupport.target.Target;
import au.com.dius.pact.provider.junitsupport.target.TestTarget;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@RunWith(RestPactRunner.class)
@Provider("Pizza-Service")
//TODO replace this with PactBroker (docker)
@PactFolder("pacts")
public class ProviderPactTest {

    private final String API_HOST = "localhost";
    private final int API_PORT = 8080;

    @TestTarget
    public final Target target = new HttpTarget(API_HOST, API_PORT);

    @State("get all pizzas")
    public void toGetState() {
        System.out.println();
    }

    @State("get by ID 1 exist")
    public void toPostState() {
        System.out.println();
    }
}
