FROM maven:3.8.4 AS build

WORKDIR /app

COPY pom.xml .
COPY src src

RUN mvn clean package

# The final image
FROM openjdk:17-jdk-slim

WORKDIR /app

EXPOSE 8080

COPY --from=build /app/target/springapp.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

