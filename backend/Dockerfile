FROM adoptopenjdk/openjdk12
WORKDIR /var/jenkins_home/workspace/deply/backend
COPY . .
RUN gradlew build
ARG JAR_FILE=build/libs/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
