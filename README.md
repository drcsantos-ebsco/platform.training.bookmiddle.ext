# Book Middle Service

Simple spring-boot spring-web API demonstrating creation of a REST Spring Boot middle service

The repo contains multiple branches, each focused on a feature:

| Branch                 | Feature                                      | Diff
| ---------------------- | -------------------------------------------- | ----
| master                 | Spring-Web REST API                          | 
| logging                | Configure log4j2 Logging and Zipkin/Sleuth   | [diff](https://github.com/EBSCOIS/platform.training.bookmiddle/compare/logging)
| test-junit             | Unit and Integration Tests (Java/JUnit)      | [diff](https://github.com/EBSCOIS/platform.training.bookmiddle/compare/test-junit)
| test-e2e               | End-to-end API Tests (Javascript/Mocha/Chai) | [diff](https://github.com/EBSCOIS/platform.training.bookmiddle/compare/test-e2e)
| configuration          | Spring Configuration and Profiles            | [diff](https://github.com/EBSCOIS/platform.training.bookmiddle/compare/configuration)
| discovery-registration | Eureka Service Discovery                     | [diff](https://github.com/EBSCOIS/platform.training.bookmiddle/compare/discovery-registration)
| circuit-breaker        | Hystrix Circuit Breaker                      | [diff](https://github.com/EBSCOIS/platform.training.bookmiddle/compare/circuit-breaker)

## Build

`$ gradle build`

## Run

`$ gradle bootRun`

## Explore

Navigate to http://localhost:8080/books from a browser or Postman.