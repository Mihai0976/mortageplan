# Use the official Maven image to create a build artifact.
# This is the build stage where we compile and package our application.
FROM maven:3.8.1-openjdk-11-slim AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

FROM openjdk:11-jre-slim
COPY --from=build /app/target/*.jar /app.jar
COPY src/main/resources/prospects.txt /app/prospects.txt
EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]

