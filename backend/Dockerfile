FROM adoptopenjdk/openjdk12:latest AS builder
WORKDIR /var/jenkins_home/workspace/deply/backend
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY settings.gradle .
COPY src src
RUN chmod +x ./gradlew
RUN ./gradlew bootJAR

FROM adoptopenjdk/openjdk12:latest
COPY --from=builder /var/jenkins_home/workspace/deply/backend/build/libs/*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "/app.jar"]
