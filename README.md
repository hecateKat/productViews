# productviews

Edge One Solutions Recruitment Project

## Requirements

For building and running the application you need:

- [JDK 1.8](http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
- [Maven](https://maven.apache.org)

## Running the application locally

There are several ways to run a Spring Boot application on your local machine. One way is to execute the `main` method in the `com/kat/productviews/ProductviewsApplication.java` class from your IDE.

Alternatively you can use the [Spring Boot Maven plugin](https://docs.spring.io/spring-boot/docs/current/reference/html/build-tool-plugins-maven-plugin.html) like so:

```shell
mvn spring-boot:run
```

## Checking functionality

At the start of the application PreloadingProduct are created and showed in logs. They all have a generated UUID number instead of int id. Please copy UUID number to use in "Get" endpoint as an "id".