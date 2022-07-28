FROM openjdk:17-alpine3.14
ARG JAR_FILE=target/song-service-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar

ENV DB_HOST=host.docker.internal
EXPOSE 8082
ENTRYPOINT ["java", "-jar","/app.jar"]