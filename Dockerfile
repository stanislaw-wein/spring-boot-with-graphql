FROM openjdk:14-alpine

ARG WAR_FILE=./target/*.war

COPY ${WAR_FILE} webapp.war

CMD ["java", "-Dspring.profiles.active=docker", "-jar", "webapp.war"]
