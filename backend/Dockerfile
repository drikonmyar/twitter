# Use Maven base image to build the application
FROM maven:3.8.6-eclipse-temurin-17 AS builder

# Set working directory to backend (where pom.xml is located)
WORKDIR /app

# Copy the backend folder to /app
COPY backend /app

# Run Maven build (now it will find pom.xml)
RUN mvn clean package -DskipTests

# Use a lightweight JDK image for final container
FROM eclipse-temurin:17-jdk
WORKDIR /app

# Copy the built JAR file from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the application port
EXPOSE 8081

# Run the application
CMD ["java", "-jar", "app.jar"]