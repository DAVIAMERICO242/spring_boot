FROM openjdk:17-alpine

WORKDIR /app

COPY ./target/*.jar /app/auth.jar

CMD ["java", "-jar", "auth.jar"]