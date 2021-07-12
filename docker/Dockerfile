FROM openjdk:8-alpine

ARG SPRING_PROFILES_ACTIVE=dev

RUN mkdir /app
RUN addgroup --system javauser && adduser -S -s /bin/false -G javauser javauser

WORKDIR /app
COPY ./target/demo-api-app-new-0.0.1-SNAPSHOT.jar ./application.jar
RUN chown -R javauser:javauser /app
USER javauser

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "./application.jar", "-Dspring.profiles.active=${SPRING_PROFILES_ACTIVE}"]
