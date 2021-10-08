FROM openjdk:8-jdk-alpine

COPY /target/team2-backend-0.0.1-SNAPSHOT.jar team2-backend-0.0.1-SNAPSHOT.jar

EXPOSE 5000

ENTRYPOINT ["java", "-jar", "/team2-backend-0.0.1-SNAPSHOT.jar"]