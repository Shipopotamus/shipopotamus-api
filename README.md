# Project structure

## Modules

### application

Module responsible for attaching all submodules to one Spring Boot application

### authentication

Module responsible for authentication bounded context.


# How to build an executable jar

`./gradlew clean build`

The jar will be located under path `/application/build/libs/application-0.0.1-SNAPSHOT.jar`

Executing via `java -jar <path to jar file>`

# How to run

`./gradlew :application:bootRun`
