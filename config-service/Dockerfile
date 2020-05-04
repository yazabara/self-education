FROM openjdk:8-jdk-alpine

WORKDIR /app

COPY target/config-service-executable.jar /app/
COPY configs/ /app/configs/

ADD https://github.com/ufoscout/docker-compose-wait/releases/download/2.7.3/wait /wait
RUN chmod +x /wait

CMD wait && java -jar config-service-executable.jar