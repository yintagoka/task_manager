# syntax=docker/dockerfile:1
FROM openjdk:17-alpine3.14
WORKDIR /app
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline -Dsilent=true || true
COPY src ./src
RUN ./mvnw clean package
CMD ["java","-jar","./target/task_manager-1.0-SNAPSHOT.jar", "server"]
# CMD tail -f /dev/null