# Jdk base
FROM openjdk:17-jdk-slim
EXPOSE 8080
VOLUME /tmp
COPY build/libs/participant-service-0.0.1-SNAPSHOT.jar participant-service.jar
ENTRYPOINT ["java","-jar","/participant-service.jar"]