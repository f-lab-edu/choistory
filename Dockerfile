FROM openjdk:21-jdk-slim AS builder
LABEL authors="khhan"

WORKDIR /app
COPY . /app/.
RUN ./gradlew build

FROM openjdk:21-jdk-slim

COPY --from=builder app/build/libs/*.jar app.jar

CMD ["java", "-jar", "app.jar", "--spring.profiles.active=local-docker"]