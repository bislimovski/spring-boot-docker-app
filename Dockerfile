FROM openjdk:8-jdk-alpine
VOLUME /tmp
COPY target/*.jar docker-app.jar
ENTRYPOINT ["java","-jar","/docker-app.jar"]