package com.example.pact_test_provider;

import au.com.dius.pact.provider.junit.RestPactRunner;
import au.com.dius.pact.provider.junit.target.HttpTarget;
import au.com.dius.pact.provider.junitsupport.Provider;
import au.com.dius.pact.provider.junitsupport.State;
import au.com.dius.pact.provider.junitsupport.loader.PactBroker;
import au.com.dius.pact.provider.junitsupport.target.Target;
import au.com.dius.pact.provider.junitsupport.target.TestTarget;
import org.junit.runner.RunWith;

@RunWith(RestPactRunner.class)
@Provider("Pizza-Service")
@PactBroker(host = "localhost", port = "9292", tags = "master")
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
