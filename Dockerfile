# Step 1: Build stage
FROM maven:3.9.9-eclipse-temurin-21-alpine AS builder

# Set the working directory
WORKDIR /app

# Copy the Maven configuration file and the source code
COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM gcr.io/distroless/java21-debian12

WORKDIR /app

COPY --from=builder /app/target/NR-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java", "-jar", "/app/NR-0.0.1-SNAPSHOT.jar"]