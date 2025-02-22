# Build stage
FROM maven:3-openjdk-22 AS build
WORKDIR /app

# Copy the Maven project files
COPY pom.xml .
COPY src ./src

# Run Maven to build the package (skip tests to speed up the build process)
RUN mvn clean package -DskipTests

# Run stage
FROM openjdk:22-jdk-slim
WORKDIR /app

# Copy the built WAR file from the build stage
COPY --from=build /app/target/NR-0.0.1-SNAPSHOT.war NR.war

# Expose port 8080 for the application
EXPOSE 8080

# Set the entry point to run the WAR file
ENTRYPOINT ["java", "-jar", "NR.war"]
