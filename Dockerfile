FROM eclipse-temurin:17-jdk-alpine
RUN addgroup -S spring && adduser -S spring -G spring
EXPOSE 8080

ENV JAVA_PROFILE prod

ARG JAR_FILE=target/rest-0.0.1-SNAPSHOT.jar
ADD ${JAR_FILE} app.jar
# ARG DEPENDENCY=target/dependency
# COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY ${DEPENDENCY}/META-INF /app/META-INF
# COPY ${DEPENDENCY}/BOOT-INF/classes /app

# ENTRYPOINT  [ "java","-Dspring.profiles.active=${JAVA_PROFILE}",\
# "-cp", "app:app/lib/*", "camt.se234.lab10.Lab10Application" ]
ENTRYPOINT  [ "java","-Dspring.profiles.active=${JAVA_PROFILE}",\
"-jar", "/app.jar" ]