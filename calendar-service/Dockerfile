FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY target/calendar-service-executable.jar /app/

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.7.3/wait /wait
RUN chmod +x /wait

CMD wait && java -jar calendar-service-executable.jar