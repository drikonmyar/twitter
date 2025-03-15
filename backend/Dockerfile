# Use Maven with JDK 21 to build the application
FROM maven:3.9.6-eclipse-temurin-21 AS builder

# Set working directory inside the container
WORKDIR /app

# Copy the backend folder to /app
COPY backend /app

# Run Maven build
RUN mvn clean package -DskipTests

# Use a lightweight JDK 21 image for running the application
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "app.jar"]