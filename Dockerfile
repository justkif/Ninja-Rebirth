FROM openjdk:22-jdk-slim
WORKDIR /app
COPY target/NR-0.0.1-SNAPSHOT.jar /app/NR.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app/NR.jar"]