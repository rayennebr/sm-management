FROM maven:3-alpine AS build
WORKDIR /app
COPY . /app
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1
COPY --from=build /app/target/*.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar"]

