1. run Pact broker container
````shell
docker-compose up
````
2. Configure pact

> Info: [Building JSON bodies with PactDslJsonBody DSL](https://github.com/pact-foundation/pact-jvm/tree/master/consumer#dsl-usage)

Pact located at `ConsumerPactTest` `consumer/src/test/java/com/example/consumer/pact/ConsumerPactTest.java`

4. Publish pact
````shell
cd ./consumer
./mvnw pact:publish
````
3. Run provider test (src/test/java/com/example/provider/ProviderPactTest.java)