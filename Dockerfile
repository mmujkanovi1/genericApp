FROM openjdk:17-jdk-alpine as faktoring
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar","--spring.config.location=/usr/share/config/"]