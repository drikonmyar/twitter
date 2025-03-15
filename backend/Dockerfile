# Use an official JDK runtime as a parent image
FROM eclipse-temurin:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container (ensure the correct build path)
COPY target/*.jar app.jar

# Expose port 8081 (matches your application)
EXPOSE 8081

# Command to run the application
CMD ["java", "-jar", "app.jar"]