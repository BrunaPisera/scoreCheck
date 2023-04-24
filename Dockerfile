FROM openjdk:17
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/score-checker-api-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} score-checker-app.jar
ENTRYPOINT ["java", "-jar", "score-checker-app.jar"]