FROM adoptopenjdk/openjdk12
WORKDIR /var/jenkins_home/workspace/deply/backend
RUN chmod 777 ./gradlew
RUN ./gradlew bootJar


ARG JAR_FILE=build/libs/*.jar
COPY --from=builder /var/jenkins_home/workspace/deply/backend/${JAR_FILE} app.jar

ENTRYPOINT ["java","-jar","app.jar"]
