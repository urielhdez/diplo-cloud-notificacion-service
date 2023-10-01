# FROM openjdk:17-jdk-alpine
FROM openjdk:17-oracle
MAINTAINER Alfonso Rivero <alfonsorivero@midas-mx.com>
# a default value
ENV MONGO_HOSTNAME mongodb+srv://<username>:<password>@cluster0.29uxujr.mongodb.net/<database>
ENV MONGO_DB <database>
ENV MONGO_USER <username>
ENV MONGO_PWD <password>
ENV TOMCAT_PORT 8080
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
CMD ["java", "-jar", "/app.jar"]