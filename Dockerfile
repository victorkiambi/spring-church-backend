FROM openjdk:17-jdk-slim as build
WORKDIR /project

COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY src src

#RUN ./gradlew build -x test

# Stage 2: Create the runtime image
FROM openjdk:17-jdk-slim
VOLUME /tmp
#COPY --from=build ./build/libs/project-0.0.1-SNAPSHOT.jar app.jar
COPY ./build/libs/project-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar"]
