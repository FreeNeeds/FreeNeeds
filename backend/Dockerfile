FROM adoptopenjdk/openjdk12 AS builder
WORKDIR /var/jenkins_home/workspace/deply/backend
RUN chmod 777 ./gradlew
RUN ./gradlew bootJar

FROM adoptopenjdk/openjdk12
ARG JAR_FILE=build/libs/*.jar
COPY --from=builder /var/jenkins_home/workspace/deply/backend/${JAR_FILE} app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","/app.jar"]
