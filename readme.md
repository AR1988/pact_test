[comment]: <> (1. run Pact broker container)

[comment]: <> (````shell)

[comment]: <> (docker-compose up)

[comment]: <> (````)

[comment]: <> (2. Configure pact)

[comment]: <> (> Info: [Building JSON bodies with PactDslJsonBody DSL]&#40;https://github.com/pact-foundation/pact-jvm/tree/master/consumer#dsl-usage&#41;)

[comment]: <> (Pact located at `ConsumerPactTest` `consumer/src/test/java/com/example/consumer/pact/ConsumerPactTest.java`)

[comment]: <> (4. Publish pact)

[comment]: <> (````shell)

[comment]: <> (cd ./consumer)

[comment]: <> (./mvnw pact:publish)

[comment]: <> (````)

[comment]: <> (3. Run provider test &#40;src/test/java/com/example/provider/ProviderPactTest.java&#41;)