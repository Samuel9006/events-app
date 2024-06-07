# Jdk base
FROM openjdk:17-jdk-slim
VOLUME /tmp
COPY build/libs/event-service-0.0.1-SNAPSHOT.jar books-service.jar
ENTRYPOINT ["java","-jar","/books-service.jar"]