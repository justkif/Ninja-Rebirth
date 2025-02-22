# Use Maven to build the application and OpenJDK to run it
FROM maven:3.8.6-openjdk-22-slim as builder

# Set the working directory for Maven build
WORKDIR /build

# Copy the pom.xml and source code to the build container
COPY pom.xml /build/pom.xml
COPY src /build/src

# Build the application
RUN mvn clean package

# Now, create a new container for the runtime environment
FROM openjdk:22-jdk-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file from the build container
COPY --from=builder /build/target/NR-0.0.1-SNAPSHOT.jar /app/NR.jar

# Expose the port that your Spring Boot application will run on
EXPOSE 10000

# Command to run the Spring Boot application
ENTRYPOINT ["java", "-jar", "/app/NR.jar"]
