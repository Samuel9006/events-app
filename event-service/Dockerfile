# Jdk base
FROM openjdk:17-jdk-slim
EXPOSE 8080
VOLUME /tmp
COPY build/libs/event-service-0.0.1-SNAPSHOT.jar event-service.jar
ENTRYPOINT ["java","-jar","/event-service.jar"]