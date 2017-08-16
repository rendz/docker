FROM  openjdk:8-jdk-alpine

RUN mkdir /service

COPY "target/simple-service-1.0-SNAPSHOT.jar" /service/service.jar

EXPOSE 5005

ENTRYPOINT java $DEBUG -jar /service/service.jar