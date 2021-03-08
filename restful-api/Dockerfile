FROM openjdk:8-jdk-alpine

RUN mkdir -p /app

WORKDIR /app

COPY target/restfulapi-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java","-Dspring.data.mongodb.uri=mongodb://mongo:27017/database","-jar","app.jar"]