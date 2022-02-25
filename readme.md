1. run Pact broker container
````shell
docker-compose up
````
2. Pablush pact contract
````shell
cd ./pact_test_consumer
./mvnw pact:publish
````
3. Run provider test (src/test/java/com/example/pact_test_provider/ProviderPactTest.java)