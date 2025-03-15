# Use an official Maven image as base
FROM maven:3.8.6-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy source code
COPY . .

# Run Maven build
RUN mvn clean package -DskipTests

# Use a lightweight JDK image for final container
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the JAR from the builder stage
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8081
CMD ["java", "-jar", "app.jar"]