FROM openjdk:17-alpine

COPY build/libs/Banco-0.0.1-SNAPSHOT.jar /app/api.jar

WORKDIR /app

EXPOSE 8080

CMD ["java", "-jar", "api.jar", "--server.port=8080"]