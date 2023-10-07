# FROM openjdk:17-alpine
# RUN addgroup -S spring && adduser -S spring -G spring
# EXPOSE 8080

# ENV JAVA_PROFILE prod
# ARG DEPENDENCY=target/dependency
# COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
# COPY ${DEPENDENCY}/META-INF /app/META-INF
# COPY ${DEPENDENCY}/BOOT-INF/classes /app



FROM openjdk:17 as JAR_EXTRACT
WORKDIR /app
ARG JAR_FILE=*.jar
COPY ./target/${JAR_FILE} ./app.jar
RUN java -Djarmode=layertools -jar ./app.jar extract

FROM  openjdk:17
WORKDIR /application
# RUN addgroup -S spring && adduser -S spring -G spring
EXPOSE 8080
COPY --from=JAR_EXTRACT /app/dependencies ./
COPY --from=JAR_EXTRACT /app/spring-boot-loader ./
COPY --from=JAR_EXTRACT /app/snapshot-dependencies ./
COPY --from=JAR_EXTRACT /app/application ./
ENV JAVA_PROFILE prod
ENTRYPOINT  [ "java","-Dspring.profiles.active=${JAVA_PROFILE}",\
"-cp", "app:app/lib/*", "se331.lab.rest.Application" ]