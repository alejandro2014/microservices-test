# microservices-test

This is little project used for a random client. The purpose is to show a simple endpoint

In order to run the tests and build the project, we must run the following command:

```
./mvnw clean install
```

This will build a report with jacoco coverage of test code, that can be shown using the web browser in the path:

```
file:///{PROJECT DIRECTORY}/target/jacoco-report/index.html
```

If we want to run the project, we need to perform the command:

```
./mvnw clean install spring-boot:run
```

